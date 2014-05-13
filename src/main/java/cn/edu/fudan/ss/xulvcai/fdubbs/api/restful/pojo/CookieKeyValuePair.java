
package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * cookie key_value pair
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "cookie_name",
    "cookie_value"
})
public class CookieKeyValuePair {

    /**
     * cookie_name
     * 
     */
    @JsonProperty("cookie_name")
    private String cookieName;
    /**
     * cookie_value
     * 
     */
    @JsonProperty("cookie_value")
    private String cookieValue;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * cookie_name
     * 
     */
    @JsonProperty("cookie_name")
    public String getCookieName() {
        return cookieName;
    }

    /**
     * cookie_name
     * 
     */
    @JsonProperty("cookie_name")
    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public CookieKeyValuePair withCookieName(String cookieName) {
        this.cookieName = cookieName;
        return this;
    }

    /**
     * cookie_value
     * 
     */
    @JsonProperty("cookie_value")
    public String getCookieValue() {
        return cookieValue;
    }

    /**
     * cookie_value
     * 
     */
    @JsonProperty("cookie_value")
    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }

    public CookieKeyValuePair withCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
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
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
