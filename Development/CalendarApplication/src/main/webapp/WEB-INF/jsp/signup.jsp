<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<!-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SingUp | Calendar Application</title>
</head> -->

<jsp:include page="fragments/header.jsp" />

<body>
	<h1>Sign Up Form</h1>

<div class="container">

	<spring:url value="/doSignup" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

		<form:hidden path="userId" />

		<spring:bind path="firstName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<form:input path="firstName" type="text" class="form-control" id="name" placeholder="Name" />
				<form:errors path="firstName" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
		  </div>
		</div>
	</form:form>

</div>

<jsp:include page="fragments/footer.jsp" />
</body>
</html>
