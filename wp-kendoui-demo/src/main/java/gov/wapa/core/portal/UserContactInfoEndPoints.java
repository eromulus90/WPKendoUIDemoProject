package gov.wapa.core.portal;

/**
 * All user contact info end points used in the API 
 * @author romulus
 *
 */
public class UserContactInfoEndPoints {

	/**
	 * get contact info{display, email and phone} for a user
	 * 
	 * @param username
	 *            -> required
	 */
	public final static String URI_USER_GET_CONTACTINFO = "user/get-contactinfo";
	/**
	 * get contact info{display, email and phone} for a client for all users
	 * 
	 * @param approle
	 *            -> required. The app role allows us to get users only for the client
	 *            In AD, an approle is set for each application to support application discovery.
	 *            If a user belongs to that role, it will be part of the list
	 * @param username
	 *            -> optional. If specified, get records for the specified user.
	 *            Otherwise, get contact info for all client users
	 */
	public final static String URI_CLIENT_GET_CONTACTINFO = "client/get-contactinfos";

}
