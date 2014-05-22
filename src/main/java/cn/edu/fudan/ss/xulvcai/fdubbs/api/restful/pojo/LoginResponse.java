
package cn.edu.fudan.ss.xulvcai.fdubbs.api.restful.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * login response
 * 
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "result_code",
    "error_message",
    "auth_code"
})
public class LoginResponse {

    /**
     * result code
     * (Required)
     * 
     */
    @JsonProperty("result_code")
    private LoginResponse.ResultCode resultCode;
    /**
     * error message
     * 
     */
    @JsonProperty("error_message")
    private String errorMessage;
    /**
     * error message
     * 
     */
    @JsonProperty("auth_code")
    private String authCode;
    private Map<String, Object> additionalProperties;

    /**
     * result code
     * (Required)
     * 
     */
    @JsonProperty("result_code")
    public LoginResponse.ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * result code
     * (Required)
     * 
     */
    @JsonProperty("result_code")
    public void setResultCode(LoginResponse.ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public LoginResponse withResultCode(LoginResponse.ResultCode resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * error message
     * 
     */
    @JsonProperty("error_message")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * error message
     * 
     */
    @JsonProperty("error_message")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LoginResponse withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * error message
     * 
     */
    @JsonProperty("auth_code")
    public String getAuthCode() {
        return authCode;
    }

    /**
     * error message
     * 
     */
    @JsonProperty("auth_code")
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public LoginResponse withAuthCode(String authCode) {
        this.authCode = authCode;
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

    @Generated("com.googlecode.jsonschema2pojo")
    public static enum ResultCode {

        SUCCESS("SUCCESS"),
        USER_NOT_EXIST("USER_NOT_EXIST"),
        PASSWD_INCORRECT("PASSWD_INCORRECT"),
        USER_ID_EMPTY("USER_ID_EMPTY"),
        PASSWD_EMPTY("PASSWD_EMPTY"),
        INTERNAL_ERROR("INTERNAL_ERROR");
        private final String value;
        private static Map<String, LoginResponse.ResultCode> constants = new HashMap<String, LoginResponse.ResultCode>();

        static {
            for (LoginResponse.ResultCode c: LoginResponse.ResultCode.values()) {
                constants.put(c.value, c);
            }
        }

        private ResultCode(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static LoginResponse.ResultCode fromValue(String value) {
            LoginResponse.ResultCode constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
