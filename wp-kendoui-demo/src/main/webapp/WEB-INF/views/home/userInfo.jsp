<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="/WEB-INF/includes/commonHeadTags.jsp"%>
<title>User info</title>
</head>
<body>
	<div class="container-fluid"
		style="height: 100%; padding-bottom: 0; margin-bottom: 0">
		<div class="row" style="height: 100%;">
			<h2>Details for ${item.displayname}</h2>

			<div>
				<h4>User info</h4>
				<hr />
				<dl class="dl-horizontal">
					<dt>Distinguished name</dt>
					<dd>${item.distinguishedname}</dd>

					<dt>Name</dt>
					<dd>${item.name}</dd>

					<dt>Given name</dt>
					<dd>${item.givenname}</dd>

					<dt>Title</dt>
					<dd>${item.title}</dd>

					<dt>Department</dt>
					<dd>${item.department}</dd>

					<dt>Primary group id</dt>					
					<dd>${item.primarygroupid}</dd>
					
					
					
					<dt>Username created</dt>					
					<dd>${item.usernamecreated}</dd>
					
					<dt>Last Logon timestamp</dt>					
					<dd>${item.lastlogontimestamp}</dd>
					
					<dt>Account expires</dt>					
					<dd>${item.accountexpires}</dd>

					<dt>Expire date</dt>					
					<dd>${item.expiredate}</dd>
					
					<dt>Password last set</dt>					
					<dd>${item.pwdlastset}</dd>
					
					<dt>INTERNAL USER</dt>					
					<dd>${item.internalUser}</dd>

				</dl>
			</div>

		</div>
	</div>
</body>
</html>