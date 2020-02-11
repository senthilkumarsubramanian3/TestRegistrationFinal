
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import='java.*'%>
<%@ page import='com.cts.bao.DisplayList'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data View Page</title>
<style>
table, th, td {
	
}

th, td {
	padding: 15px;
}

header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	background-color: #f1f1f1;
	padding: 10px;
}

body {
	background-color: #5D6D7E;
	padding: 10px;
}
</style>
<style>
.btn {
	background-color: #EC7063;
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
<!-- display details -->
<body>
	<td><input class="btn" type="button" value="Back"
		onclick="history.go(-1);" /></td>
	<center>
		<header>
		<h2>Registration Details</h2>
		</header>
		<article> <a>${error }</a>
		<table>
			<tr>
				<td>${Id }</td>
				<td>${Date }</td>
				<td>${Place }</td>
				<td>${Slot }</td>
				<td>${Level }</td>
			</tr>
		</table>
		</tr>
		</article>
	</center>
</body>
</html>
