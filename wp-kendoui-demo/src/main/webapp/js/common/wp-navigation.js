var INTERACTIVE_TAB_ACTION = "INTERACTIVE_TAB_ACTION";
/**
 * capture all clicks on the window
 */

$(document).ready(function() {
	/*
	 * capture the event and set a cookie to indicate that the user interacted with
     * tabs it was not a refresh
	 * capture click for links and buttons more may need to be added
	 */
	$("a").click(function() {
		$(".wp-sidenavigation ul li").removeClass("active");
		$(this).parent().addClass("active");
	});
});
