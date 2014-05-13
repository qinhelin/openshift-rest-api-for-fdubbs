
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
 * paragraph_content
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "br",
    "l",
    "i",
    "lr",
    "c"
})
public class ParagraphContent {

    /**
     * newline
     * 
     */
    @JsonProperty("br")
    private Boolean isNewline;
    /**
     * link
     * 
     */
    @JsonProperty("l")
    private Boolean isLink;
    /**
     * image
     * 
     */
    @JsonProperty("i")
    private Boolean isImage;
    /**
     * link ref
     * 
     */
    @JsonProperty("lr")
    private String linkRef;
    /**
     * content
     * 
     */
    @JsonProperty("c")
    private String content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * newline
     * 
     */
    @JsonProperty("br")
    public Boolean getIsNewline() {
        return isNewline;
    }

    /**
     * newline
     * 
     */
    @JsonProperty("br")
    public void setIsNewline(Boolean isNewline) {
        this.isNewline = isNewline;
    }

    public ParagraphContent withIsNewline(Boolean isNewline) {
        this.isNewline = isNewline;
        return this;
    }

    /**
     * link
     * 
     */
    @JsonProperty("l")
    public Boolean getIsLink() {
        return isLink;
    }

    /**
     * link
     * 
     */
    @JsonProperty("l")
    public void setIsLink(Boolean isLink) {
        this.isLink = isLink;
    }

    public ParagraphContent withIsLink(Boolean isLink) {
        this.isLink = isLink;
        return this;
    }

    /**
     * image
     * 
     */
    @JsonProperty("i")
    public Boolean getIsImage() {
        return isImage;
    }

    /**
     * image
     * 
     */
    @JsonProperty("i")
    public void setIsImage(Boolean isImage) {
        this.isImage = isImage;
    }

    public ParagraphContent withIsImage(Boolean isImage) {
        this.isImage = isImage;
        return this;
    }

    /**
     * link ref
     * 
     */
    @JsonProperty("lr")
    public String getLinkRef() {
        return linkRef;
    }

    /**
     * link ref
     * 
     */
    @JsonProperty("lr")
    public void setLinkRef(String linkRef) {
        this.linkRef = linkRef;
    }

    public ParagraphContent withLinkRef(String linkRef) {
        this.linkRef = linkRef;
        return this;
    }

    /**
     * content
     * 
     */
    @JsonProperty("c")
    public String getContent() {
        return content;
    }

    /**
     * content
     * 
     */
    @JsonProperty("c")
    public void setContent(String content) {
        this.content = content;
    }

    public ParagraphContent withContent(String content) {
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
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
