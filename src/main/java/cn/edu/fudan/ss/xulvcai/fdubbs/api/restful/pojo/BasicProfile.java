
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
 * basic profile
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "user_meta_data",
    "birth_date",
    "online_time",
    "register_date"
})
public class BasicProfile {

    /**
     * user meta data
     * 
     */
    @JsonProperty("user_meta_data")
    private UserMetaData userMetaData;
    /**
     * user birthday
     * 
     */
    @JsonProperty("birth_date")
    private BirthDate birthDate;
    /**
     * total online time in min
     * 
     */
    @JsonProperty("online_time")
    private Integer onlineTime;
    /**
     * register date of the user
     * 
     */
    @JsonProperty("register_date")
    private String registerDate;
    private Map<String, Object> additionalProperties;

    /**
     * user meta data
     * 
     */
    @JsonProperty("user_meta_data")
    public UserMetaData getUserMetaData() {
        return userMetaData;
    }

    /**
     * user meta data
     * 
     */
    @JsonProperty("user_meta_data")
    public void setUserMetaData(UserMetaData userMetaData) {
        this.userMetaData = userMetaData;
    }

    public BasicProfile withUserMetaData(UserMetaData userMetaData) {
        this.userMetaData = userMetaData;
        return this;
    }

    /**
     * user birthday
     * 
     */
    @JsonProperty("birth_date")
    public BirthDate getBirthDate() {
        return birthDate;
    }

    /**
     * user birthday
     * 
     */
    @JsonProperty("birth_date")
    public void setBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    public BasicProfile withBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * total online time in min
     * 
     */
    @JsonProperty("online_time")
    public Integer getOnlineTime() {
        return onlineTime;
    }

    /**
     * total online time in min
     * 
     */
    @JsonProperty("online_time")
    public void setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
    }

    public BasicProfile withOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
        return this;
    }

    /**
     * register date of the user
     * 
     */
    @JsonProperty("register_date")
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * register date of the user
     * 
     */
    @JsonProperty("register_date")
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public BasicProfile withRegisterDate(String registerDate) {
        this.registerDate = registerDate;
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
