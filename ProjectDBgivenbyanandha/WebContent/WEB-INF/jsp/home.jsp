
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
<style>
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

body {
	background-color: #5D6D7E;
	padding: 10px;
}

article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	background-color: #f1f1f1;
	padding: 10px;
	font-size: 25px;
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
<body>
	<!-- Home page -->
	<header>
	<h2>Exam Slot Booking Home Page</h2>
	<h4>Welcome ${a}</h4>
	<form action="display" method="get">
		<button type="submit">To View Exam Registered</button>
		<br>
	</form>
	</header>
	<article>
	<p>
		<span>
			<center>
				<a href="book.htm">To proceed with new registration please click
					here</a>
			</center>
		</span>
	</p>
	</article>
	<center>
		<td><input class="btn" type="button" value="Logout"
			onclick="history.go(-1);" /></td>
	</center>
</body>
</html>
