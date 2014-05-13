package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.resource;

import java.util.Date;

import javax.annotation.Generated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@Path("/heartBeat")
public class HeartBeatManager {

	public static long requestCount = 0;
	
	@GET
	@Path("/live")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHeartBeat() {
		requestCount++;

		ServerHeartBeat heartBeat = new ServerHeartBeat()
											.withServerName("jboss-rest-api-for-fdubbs")
											.withRequestCount(requestCount);
		return Response.ok().entity(heartBeat).build();
	}
}

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "server_name",
    "date",
    "request_count",
    "error_info"
})
class ServerHeartBeat {
	@JsonProperty("server_name")
	private String serverName;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("request_count")
	private long requestCount;
	
	@JsonProperty("error_info")
	private String errorInfo;
	
	ServerHeartBeat() {
		date = new Date();
	}
	
	@JsonProperty("error_info")
    public String getErrorInfo() {
        return errorInfo;
    }
	
	@JsonProperty("error_info")
    public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
    }
	
	public ServerHeartBeat withErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
        return this;
    }
	
	@JsonProperty("server_name")
    public String getServerName() {
        return serverName;
    }
	
	@JsonProperty("server_name")
    public void setServerName(String serverName) {
		this.serverName = serverName;
    }
	
	public ServerHeartBeat withServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }
	
	@JsonProperty("date")
    public Date getDate() {
        return date;
    }
	
	@JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }
	
	public ServerHeartBeat withDate(Date date) {
		this.date = date;
        return this;
    }
	
	@JsonProperty("request_count")
    public long getRequestCount() {
        return requestCount;
    }
	
	@JsonProperty("request_count")
    public void setRequestCount(long requestCount) {
		this.requestCount = requestCount;
    }
	
	public ServerHeartBeat withRequestCount(long requestCount) {
        this.requestCount = requestCount;
        return this;
    }
	
	
}
