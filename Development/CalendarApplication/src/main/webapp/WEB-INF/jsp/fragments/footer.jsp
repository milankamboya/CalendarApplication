<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<div class="container">
	<hr>
	<footer style="float:right;">
		<p>&copy; Global Calendar 2016</p>
	</footer>
</div>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="/resources/js/hello.js" var="coreJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

<spring:url value="/resources/css/jquery-ui.css" var="jqueryUiCss" />
<link href="${jqueryUiCss}" rel="stylesheet" />
<spring:url value="/resources/js/jquery-1.12.4.js" var="jquery1124Js" />
<script src="${jquery1124Js}"></script>
<spring:url value="/resources/js/jquery-ui.js" var="jqueryUiJs" />
<script src="${jqueryUiJs}"></script>
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<script>
  $( function() {
    $( "#dateOfbirth" ).datepicker();
  } );
</script>

