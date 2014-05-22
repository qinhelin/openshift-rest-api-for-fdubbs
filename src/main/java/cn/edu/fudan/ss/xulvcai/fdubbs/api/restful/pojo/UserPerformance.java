
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
 * user performance
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "performance",
    "hp",
    "level",
    "repeat",
    "contrib",
    "rank"
})
public class UserPerformance {

    /**
     * performance
     * 
     */
    @JsonProperty("performance")
    private String performance;
    /**
     * hp
     * 
     */
    @JsonProperty("hp")
    private Integer hp;
    /**
     * level
     * 
     */
    @JsonProperty("level")
    private Integer level;
    /**
     * repeat
     * 
     */
    @JsonProperty("repeat")
    private Integer repeat;
    /**
     * contrib
     * 
     */
    @JsonProperty("contrib")
    private Integer contrib;
    /**
     * rank
     * 
     */
    @JsonProperty("rank")
    private String rank;
    private Map<String, Object> additionalProperties;

    /**
     * performance
     * 
     */
    @JsonProperty("performance")
    public String getPerformance() {
        return performance;
    }

    /**
     * performance
     * 
     */
    @JsonProperty("performance")
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public UserPerformance withPerformance(String performance) {
        this.performance = performance;
        return this;
    }

    /**
     * hp
     * 
     */
    @JsonProperty("hp")
    public Integer getHp() {
        return hp;
    }

    /**
     * hp
     * 
     */
    @JsonProperty("hp")
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public UserPerformance withHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    /**
     * level
     * 
     */
    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    /**
     * level
     * 
     */
    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    public UserPerformance withLevel(Integer level) {
        this.level = level;
        return this;
    }

    /**
     * repeat
     * 
     */
    @JsonProperty("repeat")
    public Integer getRepeat() {
        return repeat;
    }

    /**
     * repeat
     * 
     */
    @JsonProperty("repeat")
    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public UserPerformance withRepeat(Integer repeat) {
        this.repeat = repeat;
        return this;
    }

    /**
     * contrib
     * 
     */
    @JsonProperty("contrib")
    public Integer getContrib() {
        return contrib;
    }

    /**
     * contrib
     * 
     */
    @JsonProperty("contrib")
    public void setContrib(Integer contrib) {
        this.contrib = contrib;
    }

    public UserPerformance withContrib(Integer contrib) {
        this.contrib = contrib;
        return this;
    }

    /**
     * rank
     * 
     */
    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    /**
     * rank
     * 
     */
    @JsonProperty("rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    public UserPerformance withRank(String rank) {
        this.rank = rank;
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
