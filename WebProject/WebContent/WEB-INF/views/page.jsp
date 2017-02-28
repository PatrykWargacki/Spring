<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
	<head>
		<title>
			WebApplicationExample
		</title>
		<link 	rel="stylesheet"
				type="text/css"
				href="<c:url value="/resources/style.css" />">
	</head>
	<body>
		<h1>Dzien Dobry</h1>
		<a href="<c:url value="/home" /> ">Go to Page 1</a>
		<a href="<c:url value="/final" /> ">Go to Book</a>
	</body>
</html>