<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Registration Form</title>
	</head>
	<body>
		<h1>Rejestracja</h1>
		<br />
		<sf:form method="POST" commandName="user">
			Imie:		<sf:input path="firstName"/><br />
			Nazwisko:	<sf:input path="lastName"/><br />
			Login:		<sf:input path="userName"/><br />
			Haslo:		<sf:password path="password"/><br />
				
				<sf:errors path="*" element="div"/><br />
				
			<input type="Submit" value="Zarejestruj"/><br />
		</sf:form>
	</body>
</html>