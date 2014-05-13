
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
 * board detail
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "section_meta_data",
    "boards"
})
public class Section {

    /**
     * section meta data
     * 
     */
    @JsonProperty("section_meta_data")
    private SectionMetaData sectionMetaData;
    /**
     * boards in the section
     * 
     */
    @JsonProperty("boards")
    private List<BoardDetail> boards = new ArrayList<BoardDetail>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * section meta data
     * 
     */
    @JsonProperty("section_meta_data")
    public SectionMetaData getSectionMetaData() {
        return sectionMetaData;
    }

    /**
     * section meta data
     * 
     */
    @JsonProperty("section_meta_data")
    public void setSectionMetaData(SectionMetaData sectionMetaData) {
        this.sectionMetaData = sectionMetaData;
    }

    public Section withSectionMetaData(SectionMetaData sectionMetaData) {
        this.sectionMetaData = sectionMetaData;
        return this;
    }

    /**
     * boards in the section
     * 
     */
    @JsonProperty("boards")
    public List<BoardDetail> getBoards() {
        return boards;
    }

    /**
     * boards in the section
     * 
     */
    @JsonProperty("boards")
    public void setBoards(List<BoardDetail> boards) {
        this.boards = boards;
    }

    public Section withBoards(List<BoardDetail> boards) {
        this.boards = boards;
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
