package gov.wapa.core.portal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for the api end point to send user preferences
 * @author romulus
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceDTO implements Serializable {
	private static final long serialVersionUID = -7629355476543777590L;
	private String username;
	private String clientId;
	private String key;
	private String value;
	
	/**
	 * preference username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * preference client id
	 * @return
	 */
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * preference key
	 * @return
	 */
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * preference value
	 * @return
	 */
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}

