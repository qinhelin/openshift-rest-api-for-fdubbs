
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
 * post qoute
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "owner",
    "content"
})
public class Qoute {

    /**
     * owner
     * 
     */
    @JsonProperty("owner")
    private String owner;
    /**
     * content
     * 
     */
    @JsonProperty("content")
    private String content;
    private Map<String, Object> additionalProperties;

    /**
     * owner
     * 
     */
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    /**
     * owner
     * 
     */
    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Qoute withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * content
     * 
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * content
     * 
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    public Qoute withContent(String content) {
        this.content = content;
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
    	if(additionalProperties == null) {
    		this.additionalProperties = new HashMap<String, Object>();
    	}
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
    	if(additionalProperties == null) {
    		this.additionalProperties = new HashMap<String, Object>();
    	}
    	
        this.additionalProperties.put(name, value);
    }

}
