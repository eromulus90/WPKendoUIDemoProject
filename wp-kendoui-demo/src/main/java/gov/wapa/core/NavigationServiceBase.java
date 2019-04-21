package gov.wapa.core;

/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : abstract class that implements the tab navigation service interface.
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

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author romulus
 *
 */
public abstract class NavigationServiceBase implements NavigationService {

	private NavigationTab activeTab = null;
	private List<NavigationTab> tabList = new ArrayList<NavigationTab>();

	/**
	 * initialize all necessary properties for the service
	 */
	public NavigationServiceBase() {

		/*
		 * initialize or populate the tab list and items
		 */
		initializeTabs(tabList);
	}

	/**
	 * Return the instance of the tab list to be used for the tabs
	 * 
	 * @return
	 */
	protected abstract void initializeTabs(List<NavigationTab> tabList);

	/**
	 * the current active tab
	 * 
	 * @return
	 */
	@Override
	public NavigationTab getActiveTab() {
		return activeTab;
	}

	@Override
	public void setActiveTab(NavigationTab activeTab) {
		this.activeTab = activeTab;
	}

	/**
	 * set a default active tab
	 */
	@Override
	public NavigationTab updateActiveTab(List<NavigationTab> authorizedTabList) {
		int index = 0;
		for (NavigationTab tab : authorizedTabList) {
			tab.setActive(false);
			if (index == 0) {
				activeTab = tab;
				activeTab.setActive(true);
			}
			index++;
		}
		return activeTab;
	}

	/**
	 * update the active tab based on the tab name
	 */
	@Override
	public NavigationTab updateActiveTab(String tabName, List<NavigationTab> authorizedTabList) {

		activeTab = null;
		for (NavigationTab tab : authorizedTabList) {
			tab.setActive(false);
			if (tab.getName().equalsIgnoreCase(tabName)) {
				activeTab = tab;
				activeTab.setActive(true);
			}
		}

		return activeTab;
	}

	/**
	 * update the active tab based on the tab name and the tabitem uri
	 */
	@Override
	public NavigationTab updateActiveTab(String tabName, String tabItemUri, List<NavigationTab> authorizedTabList) {

		if (tabItemUri != null)
			tabItemUri = tabItemUri.toLowerCase();
		/*
		 * find the target tab and activate find the target item tab and activate it
		 */
		activeTab = null;
		for (NavigationTab tab : authorizedTabList) {
			tab.setActive(false);
			if (tab.getName().equalsIgnoreCase(tabName)) {
				activeTab = tab;
				activeTab.setActive(true);
			}
		}

		if (activeTab == null)
			return activeTab;

		/*
		 * create a new list to return based on some predicates with the user roles
		 */
		List<NavigationTabItem> tabItemList = activeTab.getItemList();
		for (NavigationTabItem tabItem : tabItemList) {

			/*
			 * set the active for the current uri
			 */
			tabItem.setActive(false);
			if (tabItem.getUri().toLowerCase().contains(tabItemUri)) {
				tabItem.setActive(true);
				activeTab.setActiveTabItem(tabItem);
			}
		}

		return activeTab;
	}

	/**
	 * retrieve the list of tabs the user is authorized to use
	 * 
	 * @return
	 */
	@Override
	public List<NavigationTab> retrieveUserAuthorizedNavigationTabList() {

		String[] roles = new String[10];
		List<NavigationTab> authorizedTabList = new ArrayList<NavigationTab>();
		for (NavigationTab tab : tabList) {
			String[] tabRoles = tab.getRoles();
			/*
			 * check if the user roles have access to this category
			 */
			if (tabRoles == null || tabRoles.length == 0) {
				authorizedTabList.add(tab);
			} else {
				for (String tabRole : tabRoles) {
					if (isInRole(roles, tabRole)) {
						authorizedTabList.add(tab);
					}
				}
			}
		}
		return authorizedTabList;
	}

	/**
	 * get authorized tab items for this tab
	 * 
	 * @param tab
	 * @return
	 */
	@Override
	public List<NavigationTabItem> getAuthorizedNavigationTabItemList(NavigationTab tab, String tabItemUri) {
		if (tab == null)
			return new ArrayList<NavigationTabItem>();

		tabItemUri = tabItemUri == null ? "" : tabItemUri.toLowerCase();

		List<NavigationTabItem> tabItemList = tab.getItemList();

		String[] roles = new String[10];
		List<NavigationTabItem> authorizedTabItemList = new ArrayList<NavigationTabItem>();
		for (NavigationTabItem tabItem : tabItemList) {
			tabItem.setActive(false);
			String[] tabItemRoles = tabItem.getRoles();
			if (tabItemRoles == null || tabItemRoles.length == 0) {
				authorizedTabItemList.add(tabItem);
			} else {

				for (String tabItemRole : tabItemRoles)
					if (isInRole(roles, tabItemRole)) {
						authorizedTabItemList.add(tabItem);
					}
			}
			/*
			 * check if the tab item should be active 
			 */
			if (tabItem.getUri().toLowerCase().equals(tabItemUri))
				tabItem.setActive(true);

		}

		return authorizedTabItemList;
	}

	/**
	 * Check in a role coming from the category is in a user's list of roles
	 * 
	 * @param roles
	 * @param role
	 * @return
	 */
	private boolean isInRole(String[] roles, String role) {
		role = "ROLE_" + role;
		for (String temp : roles) {
			if(temp==null)continue;
			if (temp.equalsIgnoreCase(role))
				return true;
		}
		return false;
	}

	

}
