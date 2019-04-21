<!-- This partial view is to be included in every page. the jstl tags will be result on the page
when the following files are include in the header of the page: -->

<div class="container-fluid tab-navigation">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- tabs or menu categories -->
	<div class="outer-tab">
		<ul class="nav nav-tabs">
			<c:forEach var="tab" items="${navigationModelView.authorizedTabList}">

				<li id="${tab.name}" class="dropdown  ${ tab.cssActive}">
					<div class="btn-group">
						<a class="btn btn-link" href="${tab.defaultUri}?tab=${tab.name}"
							title="${tab.description}">
							${tab.title} </a>
						<button class="btn btn-link dropdown-toggle"
							data-toggle="dropdown">
							<span class="caret"> </span>
						</button>
						<!-- tab items or sub menu -->

						<ul class="dropdown-menu">
							<c:forEach var="tabitem" items="${tab.itemList}">
								<li class="${tabitem.cssActive }"><a
									href="${tabitem.uri}?tab=${tab.name}"
									title="${tabitem.description}">${tabitem.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

	<!-- load inner tabs -->
	<div class="inner-tab">
		<ul class="nav nav-tabs">
			<c:forEach var="tabitem"
				items="${navigationModelView.activeAuthorizedTabItemList}">
				<li class="${tabitem.cssActive }" title="${tabitem.description}"><a
					href="${tabitem.uri}?tab=${navigationModelView.activeTabName}">${tabitem.title}</a></li>
			</c:forEach>
		</ul>
	</div>

	<script src="js/includes/navigationSectionTop.js">		
	</script>

</div>