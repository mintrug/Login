<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
<style>
* {
  box-sizing: border-box;
}

input[type=text], [type=password], select, textarea {
  width: 100%;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 5px 5px 5px 0;
  display: inline-block;
}
.container {
  border-radius: 5px;
  width: 40%;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}
.row:after {
  content: "";
  display: table;
  clear: both;
}
input[type=submit] {
	margin-top: 12px;
	padding: 5px 12px;
	float: left;
}
</style>
</head>
<body>
	<h1>Register here</h1>
	<%
		String err = request.getParameter("err");
		if ("1".equals(err)) {
			out.print("<h4 style=\"color: red;\">Vui lòng không để trống</h4>");
		}
	%>
	<div class="container">
		<form action="<%=request.getContextPath()%>/Register" method="post">
			<div class="row">
				<div class="col-25">
					<label>Họ tên:</label>
				</div>
				<div class="col-75">
					<input type="text" name="name">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Tên đăng nhập:</label>
				</div>
				<div class="col-75">
					<input type="text" name="user"><br>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Mật khẩu:</label>
				</div>
				<div class="col-75">
					<input type="text" name="pass">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<input type="submit" value="Sign up" name="signup">
				</div>
				<div class="col-75">
					<input type="submit" value="Login" name="login">
				</div>
			</div>
		</form>
	</div>
</body>
</html>