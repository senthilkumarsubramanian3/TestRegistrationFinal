
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam registration page</title>
<style>
.error {
	color: red
}
</style>
<style>
#grad1 {
	height: 200px;
	background-color: #cccccc;
	background-image: linear-gradient(#4CFF33, skyblue);
}
</style>
<style>
.btn {
	background-color: #273746;
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	opacity: 0.6;
	transition: 0.3s;
}

.btn:hover {
	opacity: 1
}
</style>
</head>
<body style="background-color: skyblue;">
	<td><input class="btn" type="button" value="Back"
		onclick="history.go(-1);" /></td>

	<form:form action="booked" method="post" modelAttribute="bookmodel">
		<center>
			<div id="grad1">
				<h1>Core Java Exam Registration Page</h1>
				<table>
					<!-- input date of examination -->
					<tr>
						<td>Date of examination :</td>
						<td><form:input path="date" placeholder="dd-MM-yyyy" /></td>
						<td><form:errors path="date" cssClass="error" /></td>
					</tr>
					<!-- input date of place -->
					<tr>
						<td>Place :</td>
						<td><input list="browsers" name="place"
							placeholder="---Select---"> <datalist id="browsers">
							<option value="Siruseri">
							<option value="ASV">
							</datalist></td>
						<td><form:errors path="place" cssClass="error" /></td>
					</tr>
					<!-- input date of time slot -->
					<tr>
						<td>Slot :</td>
						<td><input list="browsers1" name="slot"
							placeholder="---Select---"> <datalist id="browsers1">
							<option value="11am - 1pm">
							<option value="2pm - 5pm">
							</datalist></td>
						<td><form:errors path="slot" cssClass="error" /></td>
					</tr>
					<!-- input date of level -->
					<tr>
						<td>Exam Toughness Level :</td>
						<td><input type="radio" name="level" value="level 1">Level
							1</td>
						<td><input type="radio" name="level" value="level 2">Level
							2</td>
						<td><form:errors path="level" cssClass="error" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><INPUT TYPE="button" onClick="history.go(0)"
							VALUE="Refresh"></td>
					</tr>
				</table>
			</div>
		</center>
	</form:form>

</body>
</html>
