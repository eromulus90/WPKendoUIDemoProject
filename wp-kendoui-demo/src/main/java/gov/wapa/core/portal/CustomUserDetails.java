package gov.wapa.core.portal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Romulus
 *
 */
public class CustomUserDetails {

	public static final long serialVersionUID = 02L;
	
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	/*
	 * 
	 */
	private List<String> roles = new ArrayList<String>();;
	private List<String> groups = new ArrayList<String>();
	private Map<String, String> preferences = new HashMap<String, String>();
	private Long orgId = null;

	private String accountexpires;
	private String badpasswordtime;
	private String department;
	private String displayname;
	private String distinguishedname;
	private String division;
	private String employeetype;
	private String expiredate;

	private String givenname;

	private boolean internalUser;

	private String lastlogontimestamp;

	private String mail;

	private String manager;

	private String name;

	private String primarygroupid;

	private String pwdlastset;

	private String title;

	/*
	 * audit
	 */
	private String usernamecreated;

	private String userprincipalname;
	
	/**
	 * accountexpires
	 * 
	 * @return
	 */
	public String getAccountexpires() {
		return accountexpires;
	}

	/**
	 * badpasswordtime -
	 * 
	 * @return
	 */
	public String getBadpasswordtime() {
		return badpasswordtime;
	}

	/**
	 * 
	 * @return
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 
	 * @return
	 */
	public String getDisplayname() {
		return displayname;
	}

	/**
	 * 
	 * @return
	 */
	public String getDistinguishedname() {

		return distinguishedname;
	}

	/**
	 * division -
	 * 
	 * @return
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * mail -
	 * 
	 * @return
	 */
	public String getEmail() {
		return mail;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmployeetype() {
		return employeetype;
	}

	/**
	 * expiredate - the date password will expire
	 * 
	 * @return
	 */
	public String getExpiredate() {
		return expiredate;
	}

	/**
	 * 
	 * @return
	 */
	public String getGivenname() {
		return givenname;
	}
	/**
	 * lastlogontimestamp -
	 * 
	 * @return
	 */
	public String getLastlogontimestamp() {
		return lastlogontimestamp;
	}

	public String getMail() {
		return mail;
	}
	/**
	 * 
	 * @return
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * primarygroupid -
	 * 
	 * @return
	 */
	public String getPrimarygroupid() {
		return primarygroupid;
	}
	/**
	 * 
	 * @return
	 */
	public String getPwdlastset() {
		return pwdlastset;
	}
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * usncreated -
	 * 
	 * @return
	 */
	public String getUsernamecreated() {
		return usernamecreated;
	}
	public String getUserprincipalname() {
		return userprincipalname;
	}
	/**
	 * userprincipalname -
	 * 
	 * @return
	 */
	public String getUserprincipalName() {
		return userprincipalname;
	}

	/**
	 * Get whether the user is coming from the internal or the external ldap.
	 * 
	 * @return
	 */
	public boolean getInternalUser() {
		return internalUser;
	}

	public void setAccountexpires(String accountexpires) {
		this.accountexpires = accountexpires;
	}

	public void setBadpasswordtime(String badpasswordtime) {
		this.badpasswordtime = badpasswordtime;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public void setDistinguishedname(String distinguishedname) {
		this.distinguishedname = distinguishedname;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public void setInternalUser(boolean internalUser) {
		this.internalUser = internalUser;
	}

	public void setLastlogontimestamp(String lastlogontimestamp) {
		this.lastlogontimestamp = lastlogontimestamp;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrimarygroupid(String primarygroupid) {
		this.primarygroupid = primarygroupid;
	}

	public void setPwdlastset(String pwdlastset) {
		this.pwdlastset = pwdlastset;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUsernamecreated(String usernamecreated) {
		this.usernamecreated = usernamecreated;
	}

	public void setUserprincipalname(String userprincipalname) {
		this.userprincipalname = userprincipalname;
	}
	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public Map<String, String> getPreferences() {
		return preferences;
	}

	public void setPreferences(Map<String, String> preferences) {
		this.preferences = preferences;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
