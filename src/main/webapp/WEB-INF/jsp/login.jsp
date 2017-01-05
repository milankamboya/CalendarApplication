<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<jsp:include page="fragments/header.jsp" />
<div class="container" style="text-align: center;">

<center><h1>Login Page</h1></center>
	<%-- <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}"> --%>
	<c:if test="${not empty param.error}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
        Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}........
	   	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
      </font>
    </c:if>
    
    <c:if test="${not empty error}">
	<div class="error">
    	Your login attempt was not successful, try again.<br />
	   	Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}........
	   	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</div>
	</c:if>

	<spring:url value="/login" var="userActionUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="loginForm" action="${userActionUrl}" name="f">
		<spring:bind path="userName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label control-label-global">UserName</label>
			<div class="col-sm-10 col-sm-10-global">
				<form:input path="userName" type="text" class="form-control" id="userName" placeholder="User Name"/>
				<form:errors path="userName" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="password">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label control-label-global">Password</label>
			<div class="col-sm-10 col-sm-10-global">
				<form:input path="password" type="password" class="form-control" id="password" placeholder="Password" />
				<form:errors path="password" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10 col-sm-10-global-button">
			     <form:button type="submit" class="btn-lg btn-primary pull-right">Login</form:button>
		  </div>
		</div>
	</form:form>
</div>
<jsp:include page="fragments/footer.jsp" />
</body>
</html>
