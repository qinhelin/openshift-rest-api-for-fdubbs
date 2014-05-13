package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.common.StringConvertHelper.*;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.exception.InvalidParameterException;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.MailDetail;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.MailMetaData;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.MailSummary;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.MailSummaryInbox;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.common.RESTErrorStatus;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.dom.DomParsingHelper;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.http.HttpClientManager;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.http.HttpParsingHelper;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.http.ReusableHttpClient;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.http.HttpParsingHelper.HttpContentType;

@Path("/mail")
public class MailManager {


	private static Logger logger = LoggerFactory.getLogger(MailManager.class);
	private static final int MAIL_NUMBER_PER_REQUEST = 20;
	
	@GET
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNewMails(@CookieParam("auth_code") String authCode) {
		
		logger.info(">>>>>>>>>>>>> Start getNewMails <<<<<<<<<<<<<<");
		
		if(authCode == null) {
			logger.info("authCode is null");
			return Response.status(RESTErrorStatus.REST_SERVER_REQUEST_CONTENT_ERROR_STATUS).build();
		}
		
		
		List<MailSummary> newMails = null;
		
		try {
			newMails = getNewMailsFromServer(authCode);
		} catch (Exception e) {
			logger.error("Exception occurs in getNewMails!", e);
			return Response.status(RESTErrorStatus.REST_SERVER_INTERNAL_ERROR_STATUS).build();
		}
		
		logger.info(">>>>>>>>>>>>> End getNewMails <<<<<<<<<<<<<<");
		return Response.ok().entity(newMails).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMails(@CookieParam("auth_code") String authCode) {
		
		logger.info(">>>>>>>>>>>>> Start getAllMails <<<<<<<<<<<<<<");
		
		if(authCode == null) {
			logger.info("authCode is null");
			return Response.status(RESTErrorStatus.REST_SERVER_REQUEST_CONTENT_ERROR_STATUS).build();
		}
		
		
		MailSummaryInbox inbox = null;
		
		try {
			inbox = getAllMailsFromServer(authCode, 0);
		} catch (Exception e) {
			logger.error("Exception occurs in getAllMails!", e);
			return Response.status(RESTErrorStatus.REST_SERVER_INTERNAL_ERROR_STATUS).build();
		}
		
		logger.info(">>>>>>>>>>>>> End getAllMails <<<<<<<<<<<<<<");
		return Response.ok().entity(inbox).build();
	}
	
	@GET
	@Path("/all/{start_num}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMailsWithStartNum(@CookieParam("auth_code") String authCode, @PathParam("start_num") int startNum) {
		
		logger.info(">>>>>>>>>>>>> Start getAllMailsWithStartNum <<<<<<<<<<<<<<");
		
		if(authCode == null) {
			logger.info("authCode is null");
			return Response.status(RESTErrorStatus.REST_SERVER_REQUEST_CONTENT_ERROR_STATUS).build();
		}
		
		
		MailSummaryInbox inbox = null;
		
		try {
			inbox = getAllMailsFromServer(authCode, startNum);
		} catch (Exception e) {
			logger.error("Exception occurs in getAllMailsWithStartNum!", e);
			return Response.status(RESTErrorStatus.REST_SERVER_INTERNAL_ERROR_STATUS).build();
		}
		
		logger.info(">>>>>>>>>>>>> End getAllMailsWithStartNum <<<<<<<<<<<<<<");
		return Response.ok().entity(inbox).build();
	}
	
	@GET
	@Path("/detail/{mail_number}/{mail_link}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMailDetailWithMailNum(@CookieParam("auth_code") String authCode, 
			@PathParam("mail_number") int mailNum, @PathParam("mail_link") String mailLink) {
		
		logger.info(">>>>>>>>>>>>> Start getMailDetailWithMailNum <<<<<<<<<<<<<<");
		
		if(authCode == null) {
			logger.info("authCode is null");
			return Response.status(RESTErrorStatus.REST_SERVER_REQUEST_CONTENT_ERROR_STATUS).build();
		}
		
		
		MailDetail mailDetail = null;
		
		try {
			mailDetail = getMailDetailFromServer(authCode, mailNum, mailLink);
		} catch (Exception e) {
			logger.error("Exception occurs in getMailDetailWithMailNum!", e);
			return Response.status(RESTErrorStatus.REST_SERVER_INTERNAL_ERROR_STATUS).build();
		}
		
		logger.info(">>>>>>>>>>>>> End getMailDetailWithMailNum <<<<<<<<<<<<<<");
		return Response.ok().entity(mailDetail).build();
	}
	
	private MailDetail getMailDetailFromServer(String authCode, int mailNum, String mailLink) throws Exception {

		ReusableHttpClient reusableClient = HttpClientManager.getInstance().getReusableClient(authCode, false);
		
		URI uri = new URIBuilder().setScheme("http")
				.setHost("bbs.fudan.edu.cn")
				.setPath("/bbs/mailcon")
				.setParameter("n", ""+mailNum)
				.setParameter("f", mailLink)
				.build();
		
		HttpGet httpGet = new HttpGet(uri);
		
		CloseableHttpResponse response = reusableClient.excuteGet(httpGet);
		
		HttpContentType httpContentType = HttpParsingHelper.getContentType(response);
		DomParsingHelper domParsingHelper = HttpParsingHelper.getDomParsingHelper(response, httpContentType);
		response.close();
		
		
		
		return  constructMailDetail(domParsingHelper, mailNum, mailLink);
	}

	private MailDetail constructMailDetail(DomParsingHelper domParsingHelper, int mailNum, String mailLink) {
		
		String title = domParsingHelper.getTextValueOfSingleNode("/bbsmailcon/t");
		
		String mailContent = domParsingHelper.getTextValueOfSingleNode("/bbsmailcon/mail");
		logger.debug("mail content : " + mailContent);
		
		int firstIdx = -1, secondIdx = -1;
		String token;
		
		token = "寄信人: ";
		firstIdx = mailContent.indexOf(token);
		mailContent = mailContent.substring(firstIdx + token.length());
		secondIdx = mailContent.indexOf(" ");
		String sender = mailContent.substring(0, secondIdx);
		
		token = "(";
		firstIdx = mailContent.indexOf("(");
		mailContent = mailContent.substring(firstIdx + token.length());
		secondIdx = mailContent.indexOf(")");
		String nick = mailContent.substring(0, secondIdx);
		
		token = "发信站: ";
		firstIdx = mailContent.indexOf(token);
		mailContent = mailContent.substring(firstIdx + token.length());
		secondIdx = mailContent.indexOf(" ");
		String source = mailContent.substring(0, secondIdx);
		
		token = "(";
		firstIdx = mailContent.indexOf("(");
		mailContent = mailContent.substring(firstIdx + token.length());
		secondIdx = mailContent.indexOf(")");
		String date = mailContent.substring(0, secondIdx);
		
		token = "来  源: ";
		firstIdx = mailContent.indexOf("来  源: ");
		mailContent = mailContent.substring(firstIdx + token.length());
		secondIdx = mailContent.indexOf("\n");
		String ip = mailContent.substring(0, secondIdx);
		
		mailContent = mailContent.substring(secondIdx+1);
		
		mailContent = mailContent.replaceAll(">1b\\[(|(\\d{1,9}(;\\d{1,9})*))m", "");
		
		MailMetaData metaData = new MailMetaData().withSender(sender)
				.withDate(date).withMailLink(encode(mailLink))
				.withMailNumber(mailNum).withNick(nick)
				.withTitle(title);
				
				
		MailDetail detail = new MailDetail().withMailMetaData(metaData).withSource(source)
				.withIp(ip).withContent(mailContent);
		
		return detail;

	}
	
	private List<MailSummary> getNewMailsFromServer(String authCode) throws Exception {
		
		ReusableHttpClient reusableClient = HttpClientManager.getInstance().getReusableClient(authCode, false);
		
		URI uri = new URIBuilder().setScheme("http").setHost("bbs.fudan.edu.cn").setPath("/bbs/newmail").build();
		HttpGet httpGet = new HttpGet(uri);
		
		CloseableHttpResponse response = reusableClient.excuteGet(httpGet);
		
		HttpContentType httpContentType = HttpParsingHelper.getContentType(response);
		DomParsingHelper domParsingHelper = HttpParsingHelper.getDomParsingHelper(response, httpContentType);
		response.close();
		
		String xpathOfMail = "/bbsmail/mail";
		
		int nodeCount = domParsingHelper.getNumberOfNodes(xpathOfMail);
		List<MailSummary> newMails = new ArrayList<MailSummary>();
		
		for(int index = 0; index < nodeCount; index++) {
			MailSummary mail = constructNewMail(domParsingHelper, xpathOfMail, index);
			newMails.add(mail);
		}
		
		return newMails;
	}
	
	private MailSummary constructNewMail(DomParsingHelper domParsingHelper, String xpathExpression, int index) {
		
		String markSign = domParsingHelper.getAttributeTextValueOfNode("m", xpathExpression, index);
		String sender = domParsingHelper.getAttributeTextValueOfNode("from", xpathExpression, index);
		String link = domParsingHelper.getAttributeTextValueOfNode("name", xpathExpression, index);
		String number = domParsingHelper.getAttributeTextValueOfNode("n", xpathExpression, index);
		String date = domParsingHelper.getAttributeTextValueOfNode("date", xpathExpression, index);
		
		String title = domParsingHelper.getTextValueOfSingleNode(xpathExpression);
		
		boolean isNew = true;
		
		MailMetaData metaData = new MailMetaData().withSender(sender)
				.withMailLink(encode(link)).withDate(date.replace('T', ' '))
				.withTitle(title).withMailNumber(convertToInteger(number));
		
		
		MailSummary mail = new MailSummary().withMailMetaData(metaData)
				.withIsNew(isNew)
				.withMarkSign(markSign);
		
		return mail;
	}
	
	private MailSummaryInbox getAllMailsFromServer(String authCode, int startNum) throws Exception {
		
		ReusableHttpClient reusableClient = HttpClientManager.getInstance().getReusableClient(authCode, false);
		
		
		URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost("bbs.fudan.edu.cn").setPath("/bbs/mail");
		if(startNum > 0) {
			uriBuilder.setParameter("start", ""+startNum);
		}
		
		URI uri = uriBuilder.build();
		HttpGet httpGet = new HttpGet(uri);
		
		CloseableHttpResponse response = reusableClient.excuteGet(httpGet);
		
		HttpContentType httpContentType = HttpParsingHelper.getContentType(response);
		DomParsingHelper domParsingHelper = HttpParsingHelper.getDomParsingHelper(response, httpContentType);
		response.close();
		
		
		MailSummaryInbox inbox = constructInbox(domParsingHelper, startNum);
		
		
		return inbox;
	}
	
	private MailSummaryInbox constructInbox(DomParsingHelper domParsingHelper, int startNum) {
		String xpathOfInbox = "/bbsmail";
		String xpathOfMail = "/bbsmail/mail";
		

		String start = domParsingHelper.getAttributeTextValueOfNode("start", xpathOfInbox, 0);
		String total = domParsingHelper.getAttributeTextValueOfNode("total", xpathOfInbox, 0);
		
		
		Integer startCount = convertToInteger(start);
		Integer totalCount = convertToInteger(total);
		
		List<MailSummary> mails = new ArrayList<MailSummary>();
		int mailCount = domParsingHelper.getNumberOfNodes(xpathOfMail);
		
		for(int idx = 0; idx < mailCount; idx++) {
			MailSummary mail = constructMail(domParsingHelper, xpathOfMail,
					idx, startCount, mailCount);
			mails.add(mail);
		}
		
		
		
		MailSummaryInbox inbox = new MailSummaryInbox().withStartMailNum(startCount)
				.withTotalCount(totalCount).withMailCount(mailCount)
				.withMailSummaryList(mails);
		
		validateAndAdjustMailList(inbox, startNum);
		return inbox;
	}
	

	private MailSummary constructMail(DomParsingHelper domParsingHelper, String xpathExpression,
			int index, int startNum, int mailCount) {
		
	
		String isRead = domParsingHelper.getAttributeTextValueOfNode("r", xpathExpression, index);
		String markSign = domParsingHelper.getAttributeTextValueOfNode("m", xpathExpression, index);
		String sender = domParsingHelper.getAttributeTextValueOfNode("from", xpathExpression, index);
		String link = domParsingHelper.getAttributeTextValueOfNode("name", xpathExpression, index);
		String date = domParsingHelper.getAttributeTextValueOfNode("date", xpathExpression, index);
		
		String title = domParsingHelper.getTextValueOfNode(xpathExpression, index);
		int mailNumber = (startNum + mailCount) - (index + 1);
		
		MailMetaData metaData = new MailMetaData().withSender(sender)
				.withMailLink(encode(link)).withDate(date.replace('T', ' '))
				.withTitle(title).withMailNumber(mailNumber);
		
		MailSummary mail = new MailSummary().withMailMetaData(metaData)
				.withIsNew("0".equals(isRead))
				.withMarkSign(markSign);
		
		return mail;
	}
	
	private void validateAndAdjustMailList(MailSummaryInbox inbox, int startNum) {
		int startMailNum = inbox.getStartMailNum();
		if(startNum > startMailNum + MAIL_NUMBER_PER_REQUEST) {
			throw new InvalidParameterException("Invalid start_num : "+startNum); 
		}
		
		if(startNum > startMailNum) {
			int redundantNum = startNum - startMailNum;
			int newMailCount = inbox.getMailCount() - redundantNum;
			RemoveRedundantMails(inbox.getMailSummaryList(), redundantNum);
			inbox.setStartMailNum(startNum);
			inbox.setMailCount(newMailCount);
		}
	}
	
	private void RemoveRedundantMails(List<MailSummary> mailSummaryList, int redundantNum) {
		for(int index = 0; index < redundantNum; index++) {
			if (mailSummaryList.isEmpty()) {
				break;
			}
			
			mailSummaryList.remove(mailSummaryList.size() - 1);//remove the tail
		}
	}
}
