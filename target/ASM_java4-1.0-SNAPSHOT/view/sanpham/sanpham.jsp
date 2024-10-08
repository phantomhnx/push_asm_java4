<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/chuyen-trang/chi-tiet-sp" method="Get">
    <button type="submit">Chi  tiết sản phẩm</button>
</form>
<form action="/chuyen-trang/chuc-vu" method="Get">
    <button type="submit">Chức vụ</button>
</form>
<form action="/chuyen-trang/khach-hang" method="Get">
    <button type="submit">Khách hàng</button>
</form>
<form action="/chuyen-trang/cua-hang" method="Get">
    <button type="submit">Cửa hàng</button>
</form>
<form action="/chuyen-trang/mau-sac" method="Get">
    <button type="submit">Màu sắc</button>
</form>
<form action="/chuyen-trang/dong-san-pham" method="Get">
    <button type="submit">Dòng sản phẩm</button>
</form>
<form action="/chuyen-trang/nha-san-xuat" method="Get">
    <button type="submit">Nhà sản xuất</button>
</form>
<form action="/chuyen-trang/nhan-vien" method="Get">
    <button type="submit">Nhân Viên</button>
</form>
<form action="/san-pham/add-sp" method="POST">
    <div>
        id : <input type="text"  value="${maId.id}" style="margin-bottom: 10px; "disabled/>
        <br/>
    </div>

    <div>
        ma : <input type="text" name="ma" value="${maId.ma}" style=" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        ten: <input type="text" name="ten" value="${maId.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <button type="submit">Add</button>
</form>


<table border="2">
    <thead>
    <tr>
        <th>id</th>
        <th>ma</th>
        <th>ten</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiSp}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <a href="/san-pham/detail-sp?maSp=${sp.id}">Detail</a>
                <a href="/san-pham/view-update-sp?maSp=${sp.id}">Edit</a>
                <a href="/san-pham/delete-sp?maSp=${sp.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
