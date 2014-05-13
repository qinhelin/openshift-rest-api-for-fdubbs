package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.http;

import java.net.URI;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.exception.InvalidParameterException;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.exception.ServerInternalException;
import cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.util.common.ErrorMessage;

public class HttpExecutionHelper {

	public static CloseableHttpResponse executeGetRequest(CloseableHttpClient client, URI uri) throws Exception {
		
		HttpGet httpGet = new HttpGet(uri);
		
		CloseableHttpResponse response = client.execute(httpGet);
		
		if(HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
			String errorMessage = HttpParsingHelper.getErrorMessageFromResponse(response);
			if(ErrorMessage.INVALID_PARAMETER_ERROR_MESSAGE.equals(errorMessage)) {
				throw new InvalidParameterException(ErrorMessage.INVALID_PARAMETER_ERROR_MESSAGE);
			}
			throw new ServerInternalException(ErrorMessage.SERVER_INTERNAL_ERROR_MESSAGE);	
		}
		
		return response;
	}
	
	public static CloseableHttpResponse executePostRequest(CloseableHttpClient client, URI uri) {
		return null;
		
	}
	
}
