
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>Success Page</title>
<style>
body {
	background-color: #777;
	padding: 10px;
	color: white;
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
	<script>
		function myFunction() {
			location.replace("index.jsp")
		}
	</script>
	<!-- success page for sign-up -->
	<button class="btn" onclick="myFunction()">Return to Login
		Page</button>
	<center>
		<h1>Successfully Signed Up</h1>
	</center>
</body>
</html>