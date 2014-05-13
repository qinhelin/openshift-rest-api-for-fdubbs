
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
 * image
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "pos",
    "ref"
})
public class Image {

    /**
     * position in the content
     * 
     */
    @JsonProperty("pos")
    private Integer pos;
    /**
     * link ref
     * 
     */
    @JsonProperty("ref")
    private String ref;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * position in the content
     * 
     */
    @JsonProperty("pos")
    public Integer getPos() {
        return pos;
    }

    /**
     * position in the content
     * 
     */
    @JsonProperty("pos")
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Image withPos(Integer pos) {
        this.pos = pos;
        return this;
    }

    /**
     * link ref
     * 
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * link ref
     * 
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    public Image withRef(String ref) {
        this.ref = ref;
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
