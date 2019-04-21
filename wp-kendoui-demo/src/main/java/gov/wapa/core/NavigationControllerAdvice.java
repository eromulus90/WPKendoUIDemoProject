package gov.wapa.core;

/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : 	controller advice for global controller attributes
 * 					every request from a controller ends up invoking this controller.
 * 					It it is also used in the tab navigation service to determines tabs and tab items 
 * 					and given user can access.
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * controller advice for global controller attributes every request from a
 * controller ends up invoking this controller. It it is also used in the tab
 * navigation service to determines tabs and tab items and given user can
 * access.
 * 
 * @author romulus
 *
 */
@ControllerAdvice(annotations = { Controller.class })
public class NavigationControllerAdvice {

	/*
	 * name of the navigation mode view
	 */
	public static final String NAVIGATION_MODEL_VIEW = "navigationModelView";
	@Autowired
	private NavigationService navigationService;

	/**
	 * retrieve and set the list of tabs for the current user
	 * 
	 * @return
	 */
	@ModelAttribute("navigationModelView")
	public NavigationModelView getNavigationTabs(HttpServletRequest request, HttpSession session) {

		/*
		 * if no tab is specified return whatever is store in the session for navigation
		 * model view
		 */
		NavigationModelView navigationModelView = (NavigationModelView) session.getAttribute(NAVIGATION_MODEL_VIEW);
		if (navigationModelView == null) {
			navigationModelView = new NavigationModelView();
			/*
			 * retrieve the authorized tabs
			 */
			List<NavigationTab> tabList = navigationService.retrieveUserAuthorizedNavigationTabList();
			navigationModelView.setAuthorizedTabList(tabList);
			NavigationTab activeTab = navigationService.updateActiveTab(tabList);
			
			/*
			 * set the authorized items
			 * set the default item to be active
			 */
			if(activeTab!=null) {
			List<NavigationTabItem> itemList = navigationService.getAuthorizedNavigationTabItemList(activeTab, null);
			activeTab.setItemList(itemList);
			}
		}


		/*
		 * set active tab and tab item
		 */
		String activeTabName = request.getParameter("tab");
		if (activeTabName != null) {

			/*
			 * get the request URI
			 */
			String activeTabItemUri = request.getRequestURI();
			activeTabItemUri = activeTabItemUri.replace(request.getContextPath() + "/", ""); // remove the context path
																								// from

			List<NavigationTab> authorizedTabList = navigationModelView.getAuthorizedTabList(); // the uri
			NavigationTab activeTab = activeTabItemUri != null
					? navigationService.updateActiveTab(activeTabName, activeTabItemUri, authorizedTabList)
					: navigationService.updateActiveTab(activeTabName, authorizedTabList);

					
			if (activeTab != null) {
				/*
				 * if the list of items is not initialized for the tab initialize it based on
				 * the user's roles to restrict access
				 */
				if (activeTab.isTabItemsInitialized() == false) {
					List<NavigationTabItem> itemList = navigationService.getAuthorizedNavigationTabItemList(activeTab, activeTabItemUri);
					activeTab.setItemList(itemList);
				}
				/*
				 * set the active tab and tab item to be used in the view model
				 */
				navigationModelView.setActiveAuthorizedTabItemList(activeTab.getItemList());
				navigationModelView.setActiveTabItem(activeTab.getActiveTabItem());
			}

		}
		
		/*
		 * save the navigation view model in the session
		 */
		session.setAttribute(NAVIGATION_MODEL_VIEW, navigationModelView);
		return navigationModelView;

	}

}
