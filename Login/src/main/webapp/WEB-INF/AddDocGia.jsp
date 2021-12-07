<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm độc giả</title>
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
	<h1>Trang thêm độc giả</h1>
	<div class="container">
		<form action="<%=request.getContextPath()%>/Add" method="post">
			<div class="row">
				<div class="col-25">
					<label> Mã độc giả: </label>
				</div>
				<div class="col-75">
					<input type="text" name="MaDG">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label> Họ độc giả: </label>
				</div>
				<div class="col-75">
					<input type="text" name="HoDG">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label> Tên độc giả </label>
				</div>
				<div class="col-75">
					<input type="text" name="TenDG">
				</div>
			</div>
	        <div class="row">
				<div class="col-25">
					<label> Ngày sinh: </label>
				</div>
				<div class="col-75">
					<input type="text" name="NgaySinh">
				</div>
			</div>
	        <div class="row">
				<div class="col-25">
					<label> Giới tính </label>
				</div>
				<div class="col-75">
					<input type="text" name="GioiTinh">
				</div>
			</div>
	        <div class="row">
				<div class="col-25">
					<label> Email: </label>
				</div>
				<div class="col-75">
					<input type="text" name="Email">
				</div>
			</div>
	        <div class="row">
				<div class="col-25">
					<label> Ảnh độc giả: </label>
				</div>
				<div class="col-75">
					<input type="text" name="AnhDG">
				</div>
			</div>
	        <div class="row">
				<div class="col-25">
					<label> Mã loại độc giả: </label>
				</div>
				<div class="col-75">
					<input type="text" name="MaLDG">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<input type="submit" value="Thêm" name="state">
				</div>
				<div class="col-75">
					<input type="submit" value="Hủy" name="state">
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>