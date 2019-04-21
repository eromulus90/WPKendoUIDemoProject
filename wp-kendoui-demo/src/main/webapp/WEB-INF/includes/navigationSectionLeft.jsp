<!-- This partial view is to be included in every page. the jstl tags will be result on the page
when the following files are include in the header of the page: -->

<div>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- load inner tabs -->
	<div class="wp-active-tab-name">${navigationModelView.activeTab.title}</div>
	<ul>
		<c:forEach var="tabitem"
			items="${navigationModelView.activeAuthorizedTabItemList}">
			<li class="${tabitem.cssActive } ${tabitem.cssSeparator } " title="${tabitem.description}"><a
				href="${tabitem.uri}?tab=${navigationModelView.activeTabName}">${tabitem.title}</a></li>
		</c:forEach>
	</ul>


	<script>
		$(document).ready(function() {
			/*
			 * two column navigation initialization for side strip toggle
			 */
			$(".wp-sidestrip").on("click", function() {
				$(".arrow").toggleClass("left");
				$(".arrow").toggleClass("right");
				$(".wp-sidenavigation").toggleClass("wp-toggle-display");
			});
		});
	</script>

</div>