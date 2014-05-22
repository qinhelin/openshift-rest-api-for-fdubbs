
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
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * content
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "text",
    "images"
})
public class Content {

    /**
     * text content
     * 
     */
    @JsonProperty("text")
    private String text;
    /**
     * images in the content
     * 
     */
    @JsonProperty("images")
    private List<Image> images;
    private Map<String, Object> additionalProperties;

    /**
     * text content
     * 
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text content
     * 
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public Content withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * images in the content
     * 
     */
    @JsonProperty("images")
    public List<Image> getImages() {    	
        return images;
    }

    /**
     * images in the content
     * 
     */
    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Content withImages(List<Image> images) {
        this.images = images;
        return this;
    }
    
    public void addImage(Image image) {
    	if (images == null) {
    		images = new ArrayList<Image>();
    	}
    	
    	images.add(image);
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
