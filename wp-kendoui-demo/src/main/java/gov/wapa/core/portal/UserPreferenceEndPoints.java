package gov.wapa.core.portal;

/**
 * All preference end points used in the API 
 * @author romulus
 *
 */
public class UserPreferenceEndPoints {

	/**
	 * get preferences for a user
	 * 
	 * @param username
	 *            -> required
	 * @param clientid
	 *            -> required
	 * @param key
	 *            -> optional. If specified, get a record for the specified key.  
	 *            Otherwise, get all preferences for the client specified user
	 */
	public final static String URI_USER_GET_PREFERENCES = "user/get-preferences";
	/**
	 * get preferences for a client for all users
	 * 
	 * @param clientid
	 *            -> required
	 * @param key
	 *            -> optional. If specified, get records for the specified key.
	 *            Otherwise, get all preferences for all client users
	 */
	public final static String URI_CLIENT_GET_PREFERENCES = "client/get-preferences";

	/**
	 * get preference definitions for a client
	 * 
	 * @param clientid
	 *            -> required
	 * @param key
	 *            -> optional. If specified, get records for the specified key.
	 *            Otherwise, get all preference definitions for the client
	 * 
	 */
	public final static String URI_CLIENT_GET_PREFERENCE_DEFINITIONS = "client/get-preference-definitions";
}
