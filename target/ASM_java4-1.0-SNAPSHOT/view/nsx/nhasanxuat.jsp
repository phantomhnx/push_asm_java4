<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/chuyen-trang/nhan-vien" method="Get">
    <button type="submit">Nhân Viên</button>
</form>
<form action="/chuyen-trang/san-pham" method="Get">
    <button type="submit">Sản phẩm</button>
</form>
<form action="/nha-san-xuat/add-nsx" method="POST">
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
        <th>ten</th>
        <th>ma</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiNsx}" var="nsx">
        <tr>
            <td>${nsx.id}</td>
            <td>${nsx.ten}</td>
            <td>${nsx.ma}</td>
            <td>
                <a href="/nha-san-xuat/detail-nsx?maNsx=${nsx.id}">Detail</a>
                <a href="/nha-san-xuat/view-update-nsx?maNsx=${nsx.id}">Edit</a>
                <a href="/nha-san-xuat/delete-nsx?maNsx=${nsx.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
