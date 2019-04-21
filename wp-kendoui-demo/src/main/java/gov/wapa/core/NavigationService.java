package gov.wapa.core;

import java.util.List;

/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : This interface defines contracts for the tab navigation service.
 * 
 * 
 * @PROGRAM : application template :  11/15/2018 FUNCTION :
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

/**
 * 
 * @author romulus
 *
 */
public interface NavigationService {
	/**
	 * the current active tab
	 * 
	 * @return
	 */
	public NavigationTab getActiveTab();

	public void setActiveTab(NavigationTab activeTab);

	/**
	 * update the active tab
	 * set a default active tab when no target is passed
	 * @param tabName
	 * @param authorizedTabList
	 */
	public NavigationTab updateActiveTab(List<NavigationTab> authorizedTabList);
	public NavigationTab updateActiveTab(String tabName, List<NavigationTab> authorizedTabList);
	public NavigationTab updateActiveTab(String tabName, String tabItemUri, List<NavigationTab> authorizedTabList);

	/**
	 * retrieve the list of tabs the user is authorized to use
	 * 
	 * @return
	 */
	public List<NavigationTab> retrieveUserAuthorizedNavigationTabList();

	/**
	 * 
	 * @param tab
	 * @param tabItemUri
	 * @return
	 */
	public List<NavigationTabItem> getAuthorizedNavigationTabItemList(NavigationTab tab, String tabItemUri );

}
