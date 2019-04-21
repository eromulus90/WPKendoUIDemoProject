<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/includes/commonHeadTags.jsp"%>
<title>Welcome to Resource Calculator</title>
</head>
<body>
<code>
	/**
	 * This page does not serve any purpose other providing info to developers
	 * The controller end point for home page will redirect to the right uri
	 *
	 * end point to the home page
	 * This home gets the navigation view model session attribute from the controller advice
	 * Retrieves the active tab and loads the active tab item.
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String home(
			@SessionAttribute(NavigationControllerAdvice.NAVIGATION_MODEL_VIEW) NavigationModelView viewModel) {

		NavigationTab tab = viewModel.getActiveTab();
		NavigationTabItem item = tab.getActiveTabItem();
		String uri = item.getUri();

		return "redirect:" + uri; // redirect to the active uri the navigation service has determined.
	}
</code>

</body>
</html>