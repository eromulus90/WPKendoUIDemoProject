<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/includes/commonHeadTags.jsp"%>
<title>download file</title>
</head>
<body style="height: 100%">
	Select the file format type you would like uploaded.  The row centric is the original " +
                     "file upload format with the start and end times in these files are ISO date and times with a time " +
                     "zone offset.  An example would be: 2018-12-04T03:00:00-7:00.  The column centric format contains a" +
                     " list of hours down the column and the individual account codes across the row.  The dates are a "  +
                     "simplified format and the time zone offset is set for each column, an example of this would be -7.

<form action="">
  <input type="radio" name="fileformat" value="Row centric"> Row centric<br>
  <input type="radio" name="fileformat" value="Column centric"> Column centric<br>
</form>

<script>
var myWindow;

function openWin() {
    myWindow = window.open("", "myWindow", "width=200,height=100");
    myWindow.document.write("<p>This is 'myWindow'</p>");
}

function closeWin() {
    myWindow.close();
}
</script>
</body>
</html>