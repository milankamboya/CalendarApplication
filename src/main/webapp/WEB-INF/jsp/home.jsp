<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<jsp:include page="fragments/header.jsp" />
<div class="container" style="text-align: center;">
<br>
	<div style="text-align:center">
		<h2>
			Welcome ${user}<br> <br>
		</h2>
	</div>
<br/>
<center>This is your home page.</center>
</div>
<jsp:include page="fragments/footer.jsp" />
</body>
</html>