package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.dom;


import java.util.HashMap;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.Content;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo.Image;



public class XmlParsingHelper implements DomParsingHelper{

	private static Logger logger = LoggerFactory.getLogger(XmlParsingHelper.class);
	
	
	private Document doc;
	
	private HashMap<String, List<Node>> nodesCache = new HashMap<String, List<Node>>();
	
	
	private XmlParsingHelper(String xmlContent) throws Exception {
		String contentAsString = xmlContent.replaceAll("&amp;nbsp;"," ").replaceAll("&#160;"," ");
		doc = DocumentHelper.parseText(contentAsString);
	}
	
	public static XmlParsingHelper parseText(String xmlContent) throws Exception {
		return new XmlParsingHelper(xmlContent);
	}
	
	@Override
	public String getTextValueOfSingleNode(String xpathExpression) {
		Node node = doc.selectSingleNode(xpathExpression);
		logger.debug("Text : " + node.asXML());
		return node == null ? null : node.getText();
	}
	
	@Override
	public int getNumberOfNodes(String xpathExpression) {
		List<Node> nodes = getNodesFromCacheOrDocument(xpathExpression);
		return nodes == null ? 0 : nodes.size();
	}
	
	@Override
	public String getAttributeTextValueOfNode(String attributName, String xpathOfNode, int index) {
		
		Node node = getNodeByXpathAndIndex(xpathOfNode, index);
		
		if(node != null && node instanceof Element) {
			Element element = (Element)node;
			return element.attributeValue(attributName);
		}
		
		return null;

	}
	
	@Override
	public String getTextValueOfNode(String xpathExpression, int index) {
		Node node = getNodeByXpathAndIndex(xpathExpression, index);
		return node == null ? null : node.getText();
	}
	
	private Node getNodeByXpathAndIndex(String xpathExpression, int index) {
		List<Node> nodes = getNodesFromCacheOrDocument(xpathExpression);
		
		if(nodes == null || index < 0 || index >= nodes.size()) 
			return null;
		
		return nodes.get(index);
	}
	
	
	@SuppressWarnings("unchecked")
	private List<Node> getNodesFromCacheOrDocument(String xpathExpression) {
		if(nodesCache.containsKey(xpathExpression)){
			return nodesCache.get(xpathExpression);
		}
		
		List<Node> nodes = doc.selectNodes(xpathExpression);
		if(nodes != null) {
			nodesCache.put(xpathExpression, nodes);
		}
		return nodes;
	}

	@Override
	public Content getContentValueofNode(String xpathExpression) {
		logger.debug("getContentValueofNode : " + xpathExpression);
		
		Content content = new Content();
		StringBuilder stringBuilder = new StringBuilder();
		
		int nodeNum = getNumberOfNodes(xpathExpression);
		for(int index = 0; index < nodeNum; index++) {
			Node node = getNodeByXpathAndIndex(xpathExpression, index);
			
			
			if(node == null) 
				continue;
			
			logger.info("Node Value : " + node.asXML());
			
			if(node.hasContent() && node.getNodeType() == Node.ELEMENT_NODE) {
				getContentValueofElementNode(content, stringBuilder, (Element)node);
				stringBuilder.append("\n");
			}
		}
		
		logger.info("Paragraph content : " + stringBuilder.toString());
		content.setText(stringBuilder.toString());
		return content;
	}
	
	@SuppressWarnings("unchecked")
	private void getContentValueofElementNode(Content content, StringBuilder stringBuilder,
													Element element) {
		List<Node> childNodes = element.content();
		for (Node node : childNodes) {
			logger.info("Child Node : " + node.asXML());
			if (node.getNodeType() == Node.TEXT_NODE) {
				parseParagraphOnTextNode(stringBuilder, node);
			}
			else if (node.getNodeType() == Node.ELEMENT_NODE) {
				parseParagraphOnElementNode(content, stringBuilder, (Element)node);
			}
			else {
				logger.debug("Unsupport Type : " + node.getNodeTypeName());
				logger.debug("XML content : " + node.asXML());
			}
		}

	}

	private void parseParagraphOnTextNode(StringBuilder stringBuilder, Node node) {
		if (!"".equals(node.getText())) {
			logger.info("TEXT Node : " + node.getText());
			stringBuilder.append(node.getText());
		}
	}

	private void parseParagraphOnElementNode(Content content, 
			StringBuilder stringBuilder, Element element) {
		
		String elementName = element.getName();
		logger.debug("elementName : " + elementName);
		logger.debug("Origin xml value : " + element.asXML());
		if ("br".equalsIgnoreCase(elementName)) {
			//stringBuilder.append("\n");
		}
		else if ("a".equalsIgnoreCase(elementName)) {
			parseParagraphOnLinkNode(content, stringBuilder, element);
		}
		else if ("c".equalsIgnoreCase(elementName)) {
			parseParagraphOnTextNode(stringBuilder, element);
		}
		else {
			getContentValueofElementNode(content, stringBuilder, element);
		}	
	}

	private void parseParagraphOnLinkNode(Content content,
			StringBuilder stringBuilder, Node node) {
		
		String imageTag = getAttributeValueOnLinkNode(node, "i");
		String linkRef = getAttributeValueOnLinkNode(node, "href");
		logger.debug("imageTag : "+imageTag+", linkRef : "+linkRef);
		
		if ("i".equals(imageTag)) {
			Image image = new Image();
			image.setRef(linkRef);
			image.setPos(stringBuilder.length());
			content.addImage(image);
		}
		else {
			stringBuilder.append(linkRef);
		}
	}
	
	private String getAttributeValueOnLinkNode(Node node, String attributName) {
		
		if (node.getNodeType() != Node.ELEMENT_NODE) {
			return null;
		}
		
		String xmlString = node.asXML();
		
		int attr_index = xmlString.indexOf(attributName+"=");
		if (attr_index == -1)
			return null;
		
		int first_index = xmlString.indexOf("\"", attr_index);
		if (first_index == -1) {
			return null;
		}
		
		int second_index = xmlString.indexOf("\"", first_index+1);
		if (second_index == -1) {
			return null;
		}
		logger.debug("first_index : "+ first_index + " , second_index : "+second_index);
		String attributeValue = xmlString.substring(first_index+1, second_index);
		logger.debug("attribute "+ attributName + " : "+attributeValue);
		return attributeValue;
	}

	
	public static void main(String[] args) throws Exception {
		
		PropertyConfigurator.configure("src/main/resource/log4j.properties");
		
		
		String contentString = "<?xml version=\"1.0\" encoding=\"gb18030\"?><?xml-stylesheet type=\"text/xsl\" href=\"../xsl/bbs.xsl?v1416\"?><bbscon link='con' bid='40' anony='0' attach='0'><session m=''><p>lt  </p><u>hidennis</u><f><b>Arch_Compiler</b><b>C</b><b>Database</b><b>Emprise</b><b>Fantasy</b><b>FDU_Software</b><b>Feelings</b><b>FM_Ecommodity</b><b>FM_Ticket</b><b>Geography</b><b>Graduate</b><b>GuangDong</b><b>History</b><b>Java</b><b>Job_Intern</b><b>Job_IT</b><b>Job_Servant</b><b>Joke</b><b>KaoYan</b><b>Lessons</b><b>Love</b><b>M_GuangHua</b><b>M_Library</b><b>M_Zhangjiang</b><b>Mac</b><b>Magpie_Bridge</b><b>MerchantAgent</b><b>MobilePhone</b><b>Movie</b><b>MS_Windows</b><b>Net_Resource</b><b>Network</b><b>News</b><b>NR_Movie</b><b>NR_Music</b><b>NR_TV</b><b>Outdoors</b><b>PIC</b><b>Practice</b><b>Single</b><b>Software_06</b><b>Travel</b><b>TV</b><b>Undergraduate</b><b>Unix</b><b>Virus</b><b>Zone_C.S.</b><b>Zone_Software</b><b>OMTV</b><b>Employees</b><b>FM_PC</b><b>IT</b><b>ZJSecondhand</b><b>Losers</b><b>MyShow</b><b>Teacher</b><b>Badminton</b><b>Heart</b><b>Food</b><b>Photography</b><b>Railway</b><b>Android</b><b>Job_Plaza</b><b>M_Career</b></f></session><po fid='363147' tlast='1'><owner>xiaoxiaowu</owner><nick>xiaoxiaowu</nick><board>Job_Intern</board><title>2014微软实习生技术类职位网申今天就要截止了&#160;&#160;&#160;&#160;&#160;未来一触即变，IT女</title><date>2014年03月31日12:11:41 星期一</date>"
				+ "<pa m=\"t\"><p><a i=\"i\" href=\"http://bbs.fudan.edu.cn/upload/PIC/1266584358-5351.jpg\" /></p><p>eBay中国技术研发中心2014实习生网申启动！<a i=\"i\" href=\"http://bbs.fudan.edu.cn/upload/PIC/1266584358-5351.jpg\" />（2014暑期项目召集令！）</p><p><br /></p><p>想在一流的平台一窥电子商务的奥秘吗？想亲身参与前沿技术的创新项目吗？想和eBay, PayPal的大牛们一起参与云计算，大数据，机器学习，商业和风险分析的深入研讨吗? eBay Inc. 将为你提供丰富而有趣的实习平台，实现你的梦想！</p><p>欢迎计算机，软件，电子科学与工程，数学与统计和经济管理，生物等专业和方向大三和研究生一年级，二年级的学生</p><p>在这里</p><p>您将会有机会参加eBay Inc.暑期两个月创新研发项目中 ！</p><p>50%的机会将会在明年转成正式员工！ </p><p>您可以有长期实习的机会！</p><p>度过充实而丰富的暑假！</p><p><br /></p><p>网申及各职位介绍：<a href=\"http://vip.yingjiesheng.com/2014/ebay\" /></p><p><br /></p><p>校园宣讲及笔试行程：（以网站上的信息为准）</p><p>2014年3月29日 南京大学仙林校区 10:00AM   仙林校区10食堂3F就业中心302</p><p>2014年4月 1日   同济大学嘉定校区 15:00PM   济人楼312</p><p>2014年4月2日   交通大学闵行校区 14:00PM   学术活动中心宣讲厅</p><p>2014年4月8日   复旦大学张江校区 14:00PM   张江行政楼106</p><p>2014年4月11日 浙江大学玉泉校区18:00PM   永谦第一报告厅</p><p><br /></p><p>宣讲会将会介绍eBay Inc. 最新动向，以及在云技术，搜索，大数据等各个方向的技术成就，同时我们会分享2014 intern program的具体信息。</p><p>宣讲后讲直接进行笔试，宣讲会将会公布笔试的具体地点。</p><p>如有任何问题，可以发email到 interns@ebay.com ,我们将尽快的回复您。</p><p> </p><p>可以扫描亿贝技术招聘的官方微信，我们会有实时校招信息更新</p><p><br /></p><p><br /></p><p>招聘流程：</p><p>1. 宣讲之前在线填写简历，简历请标明GPA和专业排名</p><p>请登入<a href=\"http://vip.yingjiesheng.com/2014/ebay\" />进行在线申请（请在宣讲会之前提交简历，会根据您的简历信息安排相应的笔试场地）</p><p>详细职位信息及申请请点击<a href=\"http://vip.yingjiesheng.com/2014/ebay/interns_hp.html\" /></p><p>实习生创新项目请参考：<a href=\"http://vip.yingjiesheng.com/2014/ebay/interns_hd.html\" /></p><p><br /></p><p><br /></p></pa>"
				+ "<pa m='s'><p>--</p><p><c h='0' f='37' b='40'></c><c h='1' f='33' b='40'>※&#160;来源:·日月光华&#160;bbs.fudan.edu.cn·HTTP&#160;[FROM:&#160;58.209.191.*]</c><c h='0' f='37' b='40'></c></p></pa></po></bbscon>";
		DomParsingHelper domParsingHelper = XmlParsingHelper.parseText(contentString);
		String xpathExpression = "bbscon/po";
		int index = 0;
		String xpathOfParagraph = xpathExpression+"["+(index+1)+"]/pa";
		
		int paraNum = domParsingHelper.getNumberOfNodes(xpathOfParagraph);
		for(int paraCount = 0; paraCount < paraNum; paraCount++) {
			String xpathOfParaContent = xpathOfParagraph+"["+(paraCount+1)+"]/p";
			
			Content content = domParsingHelper.getContentValueofNode(xpathOfParaContent);
			System.out.println(content.toString());
		}
		
	}

}
