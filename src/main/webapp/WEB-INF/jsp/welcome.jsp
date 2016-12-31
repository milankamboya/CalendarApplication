<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<spring:url value="/login" var="loginUrl" />
<spring:url value="/showSignupPage" var="signUpUrl" />
<body>
<jsp:include page="fragments/header.jsp" />
<div class="container" style="text-align: center;">
<br>
	<div style="text-align:center">
		<h2>
			Welcome to ${message}<br> <br>
		</h2>
	</div>
<br/>

New user? <a href="${signUpUrl}">Signup Here</a> | Already have account ? <a href="${loginUrl}">Login Here</a> 

<jsp:include page="fragments/footer.jsp" />
</div>
</body>
</html>