<!-- common meta tags -->
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<!-- common JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- wp tags -->
<%@ taglib prefix="wp" tagdir="/WEB-INF/tags" %>

<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="username">${pageContext.request.remoteUser}</c:set>
<c:set var="contextpath">${pageContext.request.contextPath}</c:set>
<c:url var="logoutUrl" value="/logout" />
<!-- common script tags -->
<script src="${pageContext.request.contextPath}/webjars/jquery/3.1.1-1/jquery.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/kendo-ui/js/kendo.all.min.js"></script>

<!-- common stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/site.css">
<!-- favicons -->