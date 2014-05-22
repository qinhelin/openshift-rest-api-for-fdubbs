
package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * user id and cookies info
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "user_id",
    "cookies"
})
public class UserCookiesInfo {

    /**
     * user_id
     * 
     */
    @JsonProperty("user_id")
    private String userId;
    /**
     * cookies
     * 
     */
    @JsonProperty("cookies")
    private List<CookieKeyValuePair> cookies;
    private Map<String, Object> additionalProperties;

    /**
     * user_id
     * 
     */
    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    /**
     * user_id
     * 
     */
    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserCookiesInfo withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * cookies
     * 
     */
    @JsonProperty("cookies")
    public List<CookieKeyValuePair> getCookies() {
    	if (cookies == null) {
    		cookies = new ArrayList<CookieKeyValuePair>();
    	}
        return cookies;
    }

    /**
     * cookies
     * 
     */
    @JsonProperty("cookies")
    public void setCookies(List<CookieKeyValuePair> cookies) {
        this.cookies = cookies;
    }

    public UserCookiesInfo withCookies(List<CookieKeyValuePair> cookies) {
        this.cookies = cookies;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
    	if (additionalProperties == null) {
    		additionalProperties = new HashMap<String, Object>();
    	}
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
    	if (additionalProperties == null) {
    		additionalProperties = new HashMap<String, Object>();
    	}
        this.additionalProperties.put(name, value);
    }

}
