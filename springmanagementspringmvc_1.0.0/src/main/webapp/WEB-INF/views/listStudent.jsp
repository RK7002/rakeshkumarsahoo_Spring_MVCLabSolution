<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
			integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
			crossorigin="anonymous">
		
		<title>Students Directory</title>
	</head>
	<body>
		<div class="container">
			<hr>
			<center>
				<h2>GreatLearning Academy</h2>
			</center>
			<hr>
			<h3>Students Directory</h3>
			<hr>
				<form action="/springmanagementspringmvc_1.0.0/student/list"
				class="form-inline">
	
				<a href="/springmanagementspringmvc_1.0.0/student/showFormForAdd"
					class="btn btn-primary btn-sm mb-3"> Add Student </a>
				</form>
	
				<table class="table table-bordered table-striped">
					<thead class="thead-dark">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Department</th>
							<th>Country</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Students}" var="tempStudent">
							<tr>
								<td><c:out value="${tempStudent.id}" /></td>
								<td><c:out value="${tempStudent.name}" /></td>
								<td><c:out value="${tempStudent.department}" /></td>
								<td><c:out value="${tempStudent.country}" /></td>
								<td>
									<!-- Add "update" button/link --> <a
									href="/springmanagementspringmvc_1.0.0/student/showFormForUpdate?id=${tempStudent.id}"
									class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
									<a
									href="/springmanagementspringmvc_1.0.0/student/delete?id=${tempStudent.id}"
									class="btn btn-danger btn-sm"
									onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
										Delete </a>
		
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</body>
</html>
