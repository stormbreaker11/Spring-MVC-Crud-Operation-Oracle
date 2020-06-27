<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function()
			{
	$("#country").change(function()
		{
		 var country1="countryValue="+$('#country').val();
		 alert(country1)
		 
		$.ajax({
				type : "POST",
				url : "countryValue",
				data : country1,
				cache : false,
				success: function(response) 
				{
					alert(response + "response");
					if(response!="")
						{
						var responseList=response;
						var optval="<option value='sel'>select</option>";
						for (var i = 0; i < responseList.length-1; i++) 
						{
							var complist=responseList[i];
						optvalue += "<option value="+complist[0]+">"+complist[0]+"</option>";
						}
						$('#stateId').html(optvalue);
						}
					else
						{
						alert("Insufficient Details.")
						}
					
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Add team page</h1>
	<p>Here you can add a new team.</p>
	<form:form method="POST" modelAttribute="team" action="/EmployeeLogReg/process">
		<table>
			<tbody>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"></form:input></td>
				</tr>
				<tr>
					<td>Rating:</td>
					<td><form:input path="rating" id="rate"></form:input></td>
				</tr>
				<tr>
					<td>image:</td>
					<td><form:input path="image" name="image" ></form:input></td>
				</tr>
				
				<tr>
					<td><input value="Add" type="submit"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/index.html">Home page</a>
	</p>
</body>
</html>