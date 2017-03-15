<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Messages</title>
	</head>
	<body>
		<c:forEach var="message" items="${messageList}" >
			<li id="message_<c:out value="message.id" />">
				<div class="messageText">
					<c:out value="${message.text}" />
				</div>
			</li>
		</c:forEach>
	</body>
</html>