<!DOCTYPE HTML>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/resources/css/test.css">

	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


Server info: <%= application.getServerInfo() %><br>
Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
Java version: <%= System.getProperty("java.version") %><br>

</body>
</html>