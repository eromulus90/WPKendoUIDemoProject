package gov.wapa.core.portal;

import java.io.Serializable;

/**
 * DTO class for the api end point to send user contact info
 * @author romulus
 *
 */
public class UserContactInfoDTO implements Serializable {

	private static final long serialVersionUID = 6676854052358384792L;
	private String username;
	private String name;
	private String email;
	private String phone;
	
	/**
	 * get or set the username (samaccount of the user)
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * get or set the full name of the user
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get or set email for the user
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get or set phone number for the user
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}

