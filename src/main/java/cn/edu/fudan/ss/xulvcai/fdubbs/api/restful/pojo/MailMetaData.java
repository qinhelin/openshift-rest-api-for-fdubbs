
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
 * mail meta data
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "mail_number",
    "mail_link",
    "sender",
    "nick",
    "title",
    "date"
})
public class MailMetaData {

    /**
     * mail number
     * 
     */
    @JsonProperty("mail_number")
    private Integer mailNumber;
    /**
     * mail link
     * 
     */
    @JsonProperty("mail_link")
    private String mailLink;
    /**
     * sender id
     * 
     */
    @JsonProperty("sender")
    private String sender;
    /**
     * sender id
     * 
     */
    @JsonProperty("nick")
    private String nick;
    /**
     * sender id
     * 
     */
    @JsonProperty("title")
    private String title;
    /**
     * sender id
     * 
     */
    @JsonProperty("date")
    private String date;
    private Map<String, Object> additionalProperties;

    /**
     * mail number
     * 
     */
    @JsonProperty("mail_number")
    public Integer getMailNumber() {
        return mailNumber;
    }

    /**
     * mail number
     * 
     */
    @JsonProperty("mail_number")
    public void setMailNumber(Integer mailNumber) {
        this.mailNumber = mailNumber;
    }

    public MailMetaData withMailNumber(Integer mailNumber) {
        this.mailNumber = mailNumber;
        return this;
    }

    /**
     * mail link
     * 
     */
    @JsonProperty("mail_link")
    public String getMailLink() {
        return mailLink;
    }

    /**
     * mail link
     * 
     */
    @JsonProperty("mail_link")
    public void setMailLink(String mailLink) {
        this.mailLink = mailLink;
    }

    public MailMetaData withMailLink(String mailLink) {
        this.mailLink = mailLink;
        return this;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("sender")
    public String getSender() {
        return sender;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    public MailMetaData withSender(String sender) {
        this.sender = sender;
        return this;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("nick")
    public String getNick() {
        return nick;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("nick")
    public void setNick(String nick) {
        this.nick = nick;
    }

    public MailMetaData withNick(String nick) {
        this.nick = nick;
        return this;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public MailMetaData withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * sender id
     * 
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public MailMetaData withDate(String date) {
        this.date = date;
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
