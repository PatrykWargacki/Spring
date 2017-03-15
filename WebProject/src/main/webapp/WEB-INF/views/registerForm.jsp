<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Registration Form</title>
	</head>
	<body>
		<h1>Rejestracja</h1>
		<form method="post">
			Imie: 		<input type="text" name="firstName"/><br />
			Nazwisko: 	<input type="text" name="lastName"/><br />
			Login: 		<input type="text" name="userName"/><br />
			Haslo: 		<input type="text" name="password"/><br />
			<input type="Submit" value="Zarejestruj"/><br />
		</form>
	</body>
</html>