<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="postLoginUrl" value="/j_spring_security_check" />

<html>
<head>
<title>Please log in</title>
</head>

<body>
	<c:if test="${param.failed == true}">
		<div>Your login attempt failed. Please try again.</div>
	</c:if>
	<h1>Please log in</h1>
	<form class="main" action="${postLoginUrl}" method="post">
		Username: <input type="text" name="j_username" /><br /> Password: <input
			type="password" name="j_password" /><br /> <input type="checkbox"
			name="_spring_security_remember_me" /> Remember me<br /> <input
			type="submit" value="Log in" />
	</form>
</body>