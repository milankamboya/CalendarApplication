<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>

<head>
<title></title>
	<spring:url value="/resources/css/hello.css" var="coreCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<%-- <%! String username=session.getAttribute("username"); %> --%>
		<% 
		String user = (String)session.getAttribute("username");
		if(!StringUtils.isEmpty(user)){
		%>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Calendar Dashboard</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>		
		<%
		}
		%>
	</div>
</nav>