
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
 * post reply
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "board_id",
    "main_post_id",
    "has_more",
    "last_reply_id",
    "post_reply_list"
})
public class Replies {

    /**
     * board id
     * 
     */
    @JsonProperty("board_id")
    private String boardId;
    /**
     * main post id
     * 
     */
    @JsonProperty("main_post_id")
    private String mainPostId;
    /**
     * last reply id
     * 
     */
    @JsonProperty("last_reply_id")
    private String lastReplyId;
    /**
     * if has more reply
     * 
     */
    @JsonProperty("has_more")
    private Boolean hasMore;
    /**
     * post reply list
     * 
     */
    @JsonProperty("post_reply_list")
    private List<PostDetail> postReplyList;
    private Map<String, Object> additionalProperties;

    /**
     * board id
     * 
     */
    @JsonProperty("board_id")
    public String getBoardId() {
        return boardId;
    }

    /**
     * board id
     * 
     */
    @JsonProperty("board_id")
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Replies withBoardId(String boardId) {
        this.boardId = boardId;
        return this;
    }

    /**
     * main post id
     * 
     */
    @JsonProperty("main_post_id")
    public String getMainPostId() {
        return mainPostId;
    }

    /**
     * main post id
     * 
     */
    @JsonProperty("main_post_id")
    public void setMainPostId(String mainPostId) {
        this.mainPostId = mainPostId;
    }

    public Replies withMainPostId(String mainPostId) {
        this.mainPostId = mainPostId;
        return this;
    }

    /**
     * if has more reply
     * 
     */
    @JsonProperty("has_more")
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * if has more reply
     * 
     */
    @JsonProperty("has_more")
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Replies withHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }
    
    /**
     * last reply id
     * 
     */
    @JsonProperty("last_reply_id")
    public String getLastReplyId() {
        return lastReplyId;
    }

    /**
     * last reply id
     * 
     */
    @JsonProperty("last_reply_id")
    public void setLastReplyId(String lastReplyId) {
        this.lastReplyId = lastReplyId;
    }

    public Replies withLastReplyId(String lastReplyId) {
        this.lastReplyId = lastReplyId;
        return this;
    }

    /**
     * post reply list
     * 
     */
    @JsonProperty("post_reply_list")
    public List<PostDetail> getPostReplyList() {
        return postReplyList;
    }

    /**
     * post reply list
     * 
     */
    @JsonProperty("post_reply_list")
    public void setPostReplyList(List<PostDetail> postReplyList) {
        this.postReplyList = postReplyList;
    }

    public Replies withPostReplyList(List<PostDetail> postReplyList) {
        this.postReplyList = postReplyList;
        return this;
    }
    
    public void addPostReply(PostDetail reply) {
    	if (postReplyList == null) {
    		postReplyList = new ArrayList<PostDetail>();
    	}
    	
    	postReplyList.add(reply);
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
