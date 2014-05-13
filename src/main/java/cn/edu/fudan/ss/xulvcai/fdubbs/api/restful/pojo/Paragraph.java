
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
 * paragraph
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "c"
})
public class Paragraph {

    /**
     * content in the paragraph
     * 
     */
    @JsonProperty("c")
    private List<ParagraphContent> paragraphContent = new ArrayList<ParagraphContent>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * content in the paragraph
     * 
     */
    @JsonProperty("c")
    public List<ParagraphContent> getParagraphContent() {
        return paragraphContent;
    }

    /**
     * content in the paragraph
     * 
     */
    @JsonProperty("c")
    public void setParagraphContent(List<ParagraphContent> paragraphContent) {
        this.paragraphContent = paragraphContent;
    }

    public Paragraph withParagraphContent(List<ParagraphContent> paragraphContent) {
        this.paragraphContent = paragraphContent;
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
