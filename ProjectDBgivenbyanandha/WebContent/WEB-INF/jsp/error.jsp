
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>Error Page</title>
<style>
#grad1 {
	height: 200px;
	background-color: #cccccc;
	background-image: linear-gradient(#4CFF33, skyblue);
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
	<!-- error display page -->
	<td><input class="btn" type="button" value="Back"
		onclick="history.go(-1);" /></td>
	<center>
		<div id="grad1">
			<h3>Details Not Registered || You Have Already Registered For
				The Given Exam</h3>
			<p>The Employee ID need to be same as your Login ID</p>
	</center>
	</div>
	<script>
		function myFunction() {
			location.replace("index.jsp")
		}
	</script>
	<button class="btn" onclick="myFunction()">Logout</button>
</body>
</html>