
package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * board detail
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "board_meta_data",
    "category",
    "is_directory",
    "has_unread_post"
})
public class BoardDetail {

    /**
     * board meta data
     * 
     */
    @JsonProperty("board_meta_data")
    private BoardMetaData boardMetaData;
    /**
     * board category
     * 
     */
    @JsonProperty("category")
    private String category;
    /**
     * if the board is a directory which contains sub-board
     * 
     */
    @JsonProperty("is_directory")
    private Boolean isDirectory;
    /**
     * if the board contains any unread post to the user
     * 
     */
    @JsonProperty("has_unread_post")
    private Boolean hasUnreadPost;
    private Map<String, Object> additionalProperties;

    /**
     * board meta data
     * 
     */
    @JsonProperty("board_meta_data")
    public BoardMetaData getBoardMetaData() {
        return boardMetaData;
    }

    /**
     * board meta data
     * 
     */
    @JsonProperty("board_meta_data")
    public void setBoardMetaData(BoardMetaData boardMetaData) {
        this.boardMetaData = boardMetaData;
    }

    public BoardDetail withBoardMetaData(BoardMetaData boardMetaData) {
        this.boardMetaData = boardMetaData;
        return this;
    }

    /**
     * board category
     * 
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * board category
     * 
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    public BoardDetail withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * if the board is a directory which contains sub-board
     * 
     */
    @JsonProperty("is_directory")
    public Boolean getIsDirectory() {
        return isDirectory;
    }

    /**
     * if the board is a directory which contains sub-board
     * 
     */
    @JsonProperty("is_directory")
    public void setIsDirectory(Boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public BoardDetail withIsDirectory(Boolean isDirectory) {
        this.isDirectory = isDirectory;
        return this;
    }

    /**
     * if the board contains any unread post to the user
     * 
     */
    @JsonProperty("has_unread_post")
    public Boolean getHasUnreadPost() {
        return hasUnreadPost;
    }

    /**
     * if the board contains any unread post to the user
     * 
     */
    @JsonProperty("has_unread_post")
    public void setHasUnreadPost(Boolean hasUnreadPost) {
        this.hasUnreadPost = hasUnreadPost;
    }

    public BoardDetail withHasUnreadPost(Boolean hasUnreadPost) {
        this.hasUnreadPost = hasUnreadPost;
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
