package gov.wapa.core.portal;

import java.io.Serializable;

public class ActivityLog implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String message;
	private int statusCode;

	public ActivityLog() {
	}

	public ActivityLog(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
