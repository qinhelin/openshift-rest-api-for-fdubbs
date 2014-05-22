
package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo;

import java.util.HashMap;
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
 * section meta data
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "section_id",
    "section_desc"
})
public class SectionMetaData {

    /**
     * section id
     * 
     */
    @JsonProperty("section_id")
    private String sectionId;
    /**
     * section description
     * 
     */
    @JsonProperty("section_desc")
    private String sectionDesc;
    private Map<String, Object> additionalProperties;

    /**
     * section id
     * 
     */
    @JsonProperty("section_id")
    public String getSectionId() {
        return sectionId;
    }

    /**
     * section id
     * 
     */
    @JsonProperty("section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public SectionMetaData withSectionId(String sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    /**
     * section description
     * 
     */
    @JsonProperty("section_desc")
    public String getSectionDesc() {
        return sectionDesc;
    }

    /**
     * section description
     * 
     */
    @JsonProperty("section_desc")
    public void setSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
    }

    public SectionMetaData withSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
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
