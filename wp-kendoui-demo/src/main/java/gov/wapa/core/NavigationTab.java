package gov.wapa.core;
/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : model class for an tab used in the tab navigation service.
 *					This class is designed for tab navigation tab navigation normally involves a
 * 					list of categories. Under each category, there is a list of navigation items.
 * 					When a category is hovered/clicked, the list should display all the available items.
 * 					Clicking on an item will take you to to the item, then display the active
 * 					category and all the available items for that category.
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
 * This class is designed for tab navigation tab navigation normally involves a
 * list of categories. Under each category, there is a list of navigation items.
 * When a category is hovered/clicked, the list should display all the available
 * items. Clicking on an item will take you to to the item, then display the
 * active category and all the available items for that category.
 * 
 * @author romulus
 *
 */
public class NavigationTab {

	private long id;
	private String name;
	private String title;
	private String description;
	private String cssActive;
	private boolean active;

	private String defaultUri;

	private List<NavigationTabItem> itemList = new ArrayList<NavigationTabItem>();
	private NavigationTabItem activeTabItem = null;
	private boolean tabItemsInitialized;
	private String[] roles = null;

	/**
	 * constructors
	 */
	public NavigationTab() {
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param title
	 * @param roles - associated with this category if a user does not have the
	 *              role, it will not display for the user
	 */
	public NavigationTab(long id, String name, String title, String... roles) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.roles = roles;

	}

	/**
	 * 
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * list of roles that can access this category
	 * 
	 * @return
	 */
	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	/**
	 * 
	 * @return
	 */
	public String getCssActive() {
		cssActive = active ? "active" : "";
		return cssActive;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * default uri for the tab
	 * 
	 * @return
	 */
	public String getDefaultUri() {
		/*
		 * get the first item's uri in the tab default uri
		 */
		activeTabItem = itemList.stream().filter(temp -> temp.isActive()).findAny().orElse(null);
		if (activeTabItem == null) {
			activeTabItem = itemList.size() > 0 ? itemList.get(0) : null;
		}

		if (activeTabItem != null)
			defaultUri = activeTabItem.getUri();

		return defaultUri;
	}

	public void setDefaultUri(String defaultUri) {
		this.defaultUri = defaultUri;
	}

	/**
	 * 
	 * @return
	 */
	public List<NavigationTabItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<NavigationTabItem> itemList) {
		this.itemList = itemList;
		tabItemsInitialized = true;
	}

	/**
	 * an item to this category
	 * 
	 * @param item
	 */
	public void addItem(NavigationTabItem item) {
		this.itemList.add(item);

	}

	/**
	 * whether tab items have been initialized based on the user's role. That needs
	 * to happen once
	 * 
	 * @return
	 */
	public boolean isTabItemsInitialized() {
		return tabItemsInitialized;
	}

	public void setTabItemsInitialized(boolean tabItemsInitialized) {
		this.tabItemsInitialized = tabItemsInitialized;
	}

	/**
	 * 
	 * @return
	 */
	public NavigationTabItem getActiveTabItem() {

		/*
		 * if the active tab is not null set the active tab item
		 */
		if (activeTabItem == null) {
			activeTabItem = itemList.stream().filter(temp -> temp.isActive()).findAny().orElse(null);
			if (activeTabItem == null) {
				activeTabItem = itemList.size() > 0 ? itemList.get(0) : null;
				activeTabItem.setActive(true);
			}
		}

		return activeTabItem;
	}

	/**
	 * 
	 * @return
	 */
	public void setActiveTabItem(NavigationTabItem activeTabItem) {

		this.activeTabItem = activeTabItem;
		if (this.activeTabItem != null)
			this.activeTabItem.setActive(true);

	}

}
