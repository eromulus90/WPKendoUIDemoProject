package gov.wapa.kdemo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.wapa.core.NavigationService;
import gov.wapa.core.NavigationTab;
import gov.wapa.core.NavigationTabItem;

@RequestMapping("/api/nav")
@RestController
public class NavigationRestController {

	@Autowired
	private NavigationService navigationService;

	/**
	 * get navigation tabs
	 * 
	 * @return
	 */
	@RequestMapping("/get-tabs")
	public List<NavigationTab> getNavigationCategories(@RequestParam("tab") String tab) {

		List<NavigationTab> authorizedTabList = navigationService.retrieveUserAuthorizedNavigationTabList();
		navigationService.updateActiveTab(tab, authorizedTabList);

		return authorizedTabList;
	}

	/**
	 * get navigation tab items
	 * 
	 * @return
	 */
	@RequestMapping("/get-tabitems")
	public List<NavigationTabItem> getNavigationItems(@RequestParam("tab") String tab,
			@RequestParam("uri") String activeUri) {
		List<NavigationTab> authorizedTabList = navigationService.retrieveUserAuthorizedNavigationTabList();
		NavigationTab activeTab = navigationService.updateActiveTab(tab, activeUri, authorizedTabList);
		
		return activeTab.getItemList();
	}
}
