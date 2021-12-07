<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Model.User"
    import="Model.DocGia"
    import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Home Page</title>
<style>
table, th, td {
  border: 1px solid black;
}
th, td {
	padding: 5px;
}
.floatform1 {
	float: left;
}
.floatform2 {
	float: left;
	margin-left: 5px;
}
</style>
</head>
<body>
	<%
		User currentUser = (User) session.getAttribute("currentSessionUser");
	%>
	<h1>Chào Mừng <b style=color:red><%=currentUser.getFirstName() + " " %></b> Đến Với Trang Web</h1>
	<form action="<%=request.getContextPath() %>/Search" method="get">
		<label>Nhập mã độc giả: </label>
		<input type="text" name="MaDG">
		<label style="margin-left: 10px">Nhập họ độc giả: </label>
		<input type="text" name="HoDG">
		<label style="margin-left: 10px">Nhập tên độc giả: </label>
		<input type="text" name="TenDG">
		<input type="submit" value="Search" name="search">
	</form>
	<br>
	
	<table style="width:100%">
       <tr>
          <th>Mã độc giả</th>
          <th>Họ độc giả</th>
          <th>Tên độc giả</th>
          <th>Ngày sinh</th>
          <th>Giới tính</th>
          <th>Email</th>
          <th>Ảnh độc giả</th>
          <th>Mã loại độc giả</th>
          <th>Tên loại độc giả</th>
          <th colspan="2">Chức năng</th>
       </tr>
    <%
    	List<DocGia> listList = (List<DocGia>) request.getAttribute("list");
    	int i = 0;
    	for(DocGia c:listList) {
    	
    %>

          <tr>
             <td><%=listList.get(i).getMaDG() %></td>
             <td><%=listList.get(i).getHoDG() %></td>
             <td><%=listList.get(i).getTenDG() %></td>
             <td><%=listList.get(i).getNgaySinh() %></td>
             <td><%=listList.get(i).getGioiTinh() %></td>
             <td><%=listList.get(i).getEmail() %></td>
             <td><%=listList.get(i).getAnhDG() %></td>
             <td><%=listList.get(i).getMaLDG() %></td>
             <td><%=listList.get(i).getTenLDG() %></td>
             <td><a href="<%=request.getContextPath() %>/Edit?MaDG=<%=listList.get(i).getMaDG() %>">Edit</a></td>
             <td><a href="<%=request.getContextPath() %>/Delete?MaDG=<%=listList.get(i).getMaDG() %>">Delete</a></td>
          </tr>
    <%
     		i++;
    	}
    %> 
    </table>
    <br>
    <form action="<%=request.getContextPath() %>/Add" method="get" class="floatform1">
		<input type="submit" value="Thêm độc giả" name="Add">
	</form>
	<form action="<%=request.getContextPath()%>/Login" method="post" class="floatform2">
		<input type="submit" value="Log out" name="state">
	</form>
</body>
</html>