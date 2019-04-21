# this is an example of how to use the layout
# the layout container consists of two rows.
# The first row should contains the header navigation
# the second row contains the main content container.
# When using side navigation, the second row contains 3 columns:
# one for a side strip to toggle the side navigation to provide more real estate.
# the second column should contain the side navigation
# and the third and last row should contain the page content.
# see the css classes used below for the rows and columns in this layout.


<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../includes/commonHeadTags.jsp"%>
<title>Welcome to the main page</title>

</head>
<body>

<!-- Main body of the layout -->
	<div class="wp-layout-main">
		<!-- header definition -->
		<div class="wp-main-header">
			<jsp:include page="../includes/navigationSectionTop.jsp" />
		</div>

		<!-- the main content devided into 2 rows and 3 columns -->
		<div class="wp-main-content">

			<!-- side strip to toggle side navigation -->
			<div class="wp-sidestrip">
				<div class="arrow left"></div>
				<div class="caption">Navigation links</div>
			</div>
			<!-- side navigation -->
			<div class="wp-sidenavigation">
				<jsp:include page="../includes/navigationSectionLeft.jsp" />
			</div>

			<!-- the actual content of the page -->
			<div class="wp-content">

				<h1>enter page content here</h1>			

			</div>
			<!-- end of page content -->
		</div>
		<!-- end of main page -->
	</div>
	<!-- end of layout container -->
	
</body>
</html>