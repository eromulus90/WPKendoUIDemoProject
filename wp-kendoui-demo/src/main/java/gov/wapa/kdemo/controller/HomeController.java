package gov.wapa.kdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import gov.wapa.core.NavigationControllerAdvice;
import gov.wapa.core.NavigationModelView;
import gov.wapa.core.NavigationTab;
import gov.wapa.core.NavigationTabItem;

/**
 * home controller
 * 
 * @author romulus
 *
 */
@Controller
public class HomeController {
	/**
	 * end point to the home page This home gets the navigation view model session
	 * attribute from the controller advice Retrieves the active tab and loads the
	 * active tab item.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String home(
			@SessionAttribute(NavigationControllerAdvice.NAVIGATION_MODEL_VIEW) NavigationModelView viewModel) {

		NavigationTab tab = viewModel.getActiveTab();
		String uri = "error-access";
		if (tab != null) {
			NavigationTabItem item = tab.getActiveTabItem();
			uri = item.getUri();
		}

		return "redirect:" + uri; // redirect to the active uri the navigation service has determined.
	}
}
