<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="fragments/header.jsp" />

<body>
<h2>Hello World!</h2>
<br>
	<div style="text-align:center">
		<h2>
			This is first testing for CalendarApplication<br> <br>
		</h2>
		<h3>
			<a href="welcome">Click here to See Welcome Message... </a>
		</h3>
	</div>
Welcome Page
${message}

<br/>
Testing hibernate changes with spring web mvc :
<br/>

Test Login Id : ${logindetails.loginuser} 
<br/>
Test Password : ${logindetails.password}
<br/>	

<a href="signup">New user? Please signup here</a>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>