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
<div class="container">
	<center><h1>Create Global Calendar Account</h1></center>
	
	<spring:url value="/doSignup" var="userActionUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="userSignUpForm" action="${userActionUrl}">

		<form:hidden path="userId" />

		<spring:bind path="firstName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-10">
				<form:input path="firstName" type="text" value="${user.getFirstName()}" class="form-control" id="firstName" placeholder="First Name"/>
				<form:errors path="firstName" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="lastName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				<form:input path="lastName" type="text" value="${user.getLastName()}" class="form-control" id="lastName" placeholder="Last Name" />
				<form:errors path="lastName" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="email">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" type="text"  value="${user.getEmail()}" class="form-control" id="email" placeholder="Email" />
				<form:errors path="email" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="gender">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Gender</label>
			<div class="col-sm-5">
				<form:select path="gender" class="form-control" value="${user.getGender()}">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${genderList}" />
				</form:select>
				<form:errors path="gender" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="phone">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Mobile No</label>
			<div class="col-sm-10">
				<form:input path="phone" type="text" value="${user.getPhone()}" class="form-control" id="name" placeholder="Mobile No" />
				<form:errors path="phone" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="address">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Address</label>
			<div class="col-sm-10">
				<form:textarea path="address" value="${user.getAddress()}" rows="5" class="form-control" id="address" placeholder="Address" />
				<form:errors path="address" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="dateOfbirth">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Date Of Birth</label>
			<div class="col-sm-10">
				<form:input path="dateOfbirth" type="text" value="${user.getDateOfBirth()}" class="form-control" id="dateOfbirth" placeholder="Date Of Birth" />
				<form:errors path="dateOfbirth" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="userLanguage">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Language</label>
			<div class="col-sm-5">
				<form:select path="userLanguage" class="form-control" value="${user.getUserLanguage()}">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${languageList}" />
				</form:select>
				<form:errors path="userLanguage" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="timeZone">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">TimeZone</label>
			<div class="col-sm-5">
				<form:select path="timeZone" class="form-control" value="${user.getTimeZone()}">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${timezoneList}" />
				</form:select>
				<form:errors path="timeZone" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>

		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <form:button type="submit" class="btn-lg btn-primary pull-right">Add</form:button>
		  </div>
		</div>
	</form:form>

</div>

<jsp:include page="fragments/footer.jsp" />
</body>
</html>
