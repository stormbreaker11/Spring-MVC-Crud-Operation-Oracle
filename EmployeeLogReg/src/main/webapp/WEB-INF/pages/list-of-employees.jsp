<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employees</title>
</head>
<body>
	<h1>List of Employees</h1>
	<p>Here you can see the list of the Employees, edit them, remove or update.</p>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<th width="10%">id</th>
			<th width="15%">name</th>
			<th width="10%">rating</th>
			<th width="10%">Edit</th>
			<th width="10%">Delete</th>
		</tr>
		<c:forEach var="team" items="${teams}">
			<tr>
				<td>${team.id}</td>
				<td>${team.name}</td>
				<td>${team.rating}</td>
				<td><a href="edit.html?id=${team.id}">Edit</a></td>
				<td><a href="delete.html?id=${team.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>