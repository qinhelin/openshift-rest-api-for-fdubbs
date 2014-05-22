
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
 * error
 * <p>
 * Details of an Error
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "message",
    "information_link",
    "details"
})
public class Error {

    /**
     * Human readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * Message describing the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    private String message;
    /**
     * URI for detailed information related to this error for the developer.
     * (Required)
     * 
     */
    @JsonProperty("information_link")
    private String informationLink;
    /**
     * Additional details of the error
     * 
     */
    @JsonProperty("details")
    private List<Detail> details = new ArrayList<Detail>();
    private Map<String, Object> additionalProperties;

    /**
     * Human readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Human readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Error withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Message describing the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message describing the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Error withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * URI for detailed information related to this error for the developer.
     * (Required)
     * 
     */
    @JsonProperty("information_link")
    public String getInformationLink() {
        return informationLink;
    }

    /**
     * URI for detailed information related to this error for the developer.
     * (Required)
     * 
     */
    @JsonProperty("information_link")
    public void setInformationLink(String informationLink) {
        this.informationLink = informationLink;
    }

    public Error withInformationLink(String informationLink) {
        this.informationLink = informationLink;
        return this;
    }

    /**
     * Additional details of the error
     * 
     */
    @JsonProperty("details")
    public List<Detail> getDetails() {
    	if (details == null) {
    		details = new ArrayList<Detail>();
    	}
        return details;
    }

    /**
     * Additional details of the error
     * 
     */
    @JsonProperty("details")
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Error withDetails(List<Detail> details) {
        this.details = details;
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
