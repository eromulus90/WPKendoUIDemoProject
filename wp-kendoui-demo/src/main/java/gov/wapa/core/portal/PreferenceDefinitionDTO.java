package gov.wapa.core.portal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for the api end point to send preference definitions
 * 
 * @author romulus
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferenceDefinitionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -849540408963580232L;
	private String clientId;
	private String key;
	private String value;

	/**
	 * preference client id
	 * 
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
	 * 
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
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
