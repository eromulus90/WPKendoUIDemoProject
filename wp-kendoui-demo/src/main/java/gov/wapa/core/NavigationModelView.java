package gov.wapa.core;

/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : 	This navigation view is made available in the global advice as global
 * 					attribute available in every controller the tabs are filters based on the
 * 					roles in the security context holder for the current user
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
 * This navigation view is made available in the global advice as global
 * attribute available in every controller the tabs are filters based on the
 * roles in the security context holder for the current user
 * 
 * @author romulus
 *
 */
public class NavigationModelView {

	private String activeTabName;
	private NavigationTab activeTab;
	private NavigationTabItem activeTabItem;

	private List<NavigationTab> authorizedTabList = new ArrayList<NavigationTab>(); // default to an empty list;
	private List<NavigationTabItem> activeAuthorizedTabItemList = new ArrayList<NavigationTabItem>(); // default to an
	private boolean tabsInitialized;
	
	/**
	 * get the active tab name
	 * 
	 * @return
	 */
	public String getActiveTabName() {
		return activeTabName;
	}

	public void setActiveTabName(String activeTabName) {
		this.activeTabName = activeTabName;
	}

	/**
	 * 
	 * @return
	 */
	public NavigationTab getActiveTab() {

		/*
		 * set the active tab
		 */
		activeTab = authorizedTabList.stream().filter(temp -> temp.isActive()).findAny().orElse(null);
		if (activeTab == null) {
			activeTab = authorizedTabList.size() > 0 ? authorizedTabList.get(0) : null;
		}

		/*
		 * when the active tab is not null set the active tab item
		 */
		if (activeTab != null) {

			this.activeTabName = activeTab.getName();
			/*
			 * set active tab item
			 */
			activeTabItem = activeTab.getItemList().stream().filter(temp -> temp.isActive()).findAny().orElse(null);
			if (activeTabItem == null) {
				activeTabItem = activeTab.getItemList().size() > 0 ? activeTab.getItemList().get(0) : null;
				activeTabItem.setActive(true);
			}

		}

		return activeTab;
	}

	/**
	 * active tab item uri
	 * 
	 * @return
	 */

	public NavigationTabItem getActiveTabItem() {
		return activeTabItem;
	}

	public void setActiveTabItem(NavigationTabItem activeTabItem) {
		this.activeTabItem = activeTabItem;
	}

	/**
	 * list of tabs including their tab items
	 * 
	 * @return
	 */
	public List<NavigationTab> getAuthorizedTabList() {
		return authorizedTabList;
	}

	public void setAuthorizedTabList(List<NavigationTab> authorizedTabList) {
		this.authorizedTabList = authorizedTabList;

		this.tabsInitialized = true;
	}

	/**
	 * authorized list of tab items inside a tab
	 * 
	 * @return
	 */
	public List<NavigationTabItem> getActiveAuthorizedTabItemList() {

		activeTab = this.getActiveTab();
		activeAuthorizedTabItemList = activeTab != null ? activeTab.getItemList() : null;
		return activeAuthorizedTabItemList;
	}

	public void setActiveAuthorizedTabItemList(List<NavigationTabItem> activeAuthorizedTabItemList) {

		this.activeAuthorizedTabItemList = activeAuthorizedTabItemList;
	}

	/**
	 * where tabs have been initialized for the user
	 * 
	 * @return
	 */
	public boolean isTabsInitialized() {
		return tabsInitialized;
	}

	public void setTabsInitialized(boolean tabsInitialized) {
		this.tabsInitialized = tabsInitialized;
	}

}
