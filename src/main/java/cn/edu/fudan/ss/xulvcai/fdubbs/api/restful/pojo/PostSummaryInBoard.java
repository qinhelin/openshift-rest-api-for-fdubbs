
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
 * board summary in board
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "board_meta_data",
    "start_post_num",
    "post_count",
    "post_summary_list"
})
public class PostSummaryInBoard {

    /**
     * board meta data
     * 
     */
    @JsonProperty("board_meta_data")
    private BoardMetaData boardMetaData;
    /**
     * start post number
     * 
     */
    @JsonProperty("start_post_num")
    private Integer startPostNum;
    /**
     * post count
     * 
     */
    @JsonProperty("post_count")
    private Integer postCount;
    /**
     * post summary list
     * 
     */
    @JsonProperty("post_summary_list")
    private List<PostSummary> postSummaryList;
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

    public PostSummaryInBoard withBoardMetaData(BoardMetaData boardMetaData) {
        this.boardMetaData = boardMetaData;
        return this;
    }

    /**
     * start post number
     * 
     */
    @JsonProperty("start_post_num")
    public Integer getStartPostNum() {
        return startPostNum;
    }

    /**
     * start post number
     * 
     */
    @JsonProperty("start_post_num")
    public void setStartPostNum(Integer startPostNum) {
        this.startPostNum = startPostNum;
    }

    public PostSummaryInBoard withStartPostNum(Integer startPostNum) {
        this.startPostNum = startPostNum;
        return this;
    }

    /**
     * post count
     * 
     */
    @JsonProperty("post_count")
    public Integer getPostCount() {
        return postCount;
    }

    /**
     * post count
     * 
     */
    @JsonProperty("post_count")
    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public PostSummaryInBoard withPostCount(Integer postCount) {
        this.postCount = postCount;
        return this;
    }

    /**
     * post summary list
     * 
     */
    @JsonProperty("post_summary_list")
    public List<PostSummary> getPostSummaryList() {
        return postSummaryList;
    }

    /**
     * post summary list
     * 
     */
    @JsonProperty("post_summary_list")
    public void setPostSummaryList(List<PostSummary> postSummaryList) {
        this.postSummaryList = postSummaryList;
    }

    public PostSummaryInBoard withPostSummaryList(List<PostSummary> postSummaryList) {
        this.postSummaryList = postSummaryList;
        return this;
    }
    
    public void addPostSummary(PostSummary postSummary) {
    	if (postSummaryList == null) {
    		postSummaryList = new ArrayList<PostSummary>();
    	}
    	
    	postSummaryList.add(postSummary);
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
