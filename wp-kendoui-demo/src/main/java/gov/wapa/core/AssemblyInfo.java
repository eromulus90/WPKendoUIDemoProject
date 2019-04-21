/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : provides basic information about the environment and the version of the application
 * 
 * @PROGRAM : application template :  01/31/2019 FUNCTION :
 * 
 * @ENVIRONMENT : java
 * 
 * 
 * @MODIFICATION HISTORY:
 *
 * 
 * @author Emmanuel Romulus
 *
 ***********************************************************************************************/

package gov.wapa.core;

import javax.annotation.PostConstruct;

/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION :  The application assembly is a component used to get basic information about the application in terms of version number and environment 
 *                 where the application is deployed.
 * 
 * @author romulus
 * 
 * 
 * @PROGRAM : application template :  01/29/2019 FUNCTION :
 * 
 * @ENVIRONMENT : java
 * 
 * 
 * @MODIFICATION HISTORY:
 *
 * 
 * @author Emmanuel Romulus
 *
 ***********************************************************************************************/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * this component provides basic information about the environment and the
 * version of the application. The information comes the appconfig.properties
 * and wldeploy.properties files.
 * 
 * @author romulus
 *
 */
@Component
@PropertySources({ @PropertySource("classpath:wldeploy.properties") })
public class AssemblyInfo {

	@Value("${application.environment}")
	private String environment;

	@Value("${app.version.next}")
	private String version;

	@Value("${app.title}")
	private String applicationTitle;

	private String applicationVersion = "";
	private String applicationEnvironment = "";

	/**
	 * initialize transformable values
	 */
	@PostConstruct
	private void init() {
		environment = environment.toUpperCase();
		switch (environment) {
		case "DEV":
			applicationVersion = applicationTitle + " Version: " + version + "-dev";
			applicationEnvironment = "DEVELOPMENT";
			break;
		case "PROD":
			applicationVersion = applicationTitle + " Version: " + version + "-prod";
			applicationEnvironment = "PRODUCTION";
			break;
		case "STAGING":
			applicationVersion = applicationTitle + " Version: " + version + "-staging";
			applicationEnvironment = "STAGING";
			break;
		default:
			applicationVersion = applicationTitle + " Version: " + version + "-dev";
			applicationEnvironment = environment.toUpperCase();
			break;
		}
	}

	/**
	 * get the environment based on where the app is deployed
	 * 
	 * @return
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * get the version, which is the next to be deployed
	 * 
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * get the application title defined in the deployment properties
	 * 
	 * @return
	 */
	public String getApplicationTitle() {
		return applicationTitle;
	}

	/**
	 * build and return the application version
	 */
	public String getApplicationVersion() {

		return applicationVersion;
	}

	/**
	 * get a friendly name that can be displayed to users for the application
	 * environment
	 * 
	 * @return
	 */
	public String getApplicationEnvironment() {

		return applicationEnvironment;
	}

}
