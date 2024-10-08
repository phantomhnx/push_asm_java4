<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:56 PM
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
<form action="/chuyen-trang/dong-san-pham" method="Get">
    <button type="submit">Dòng sản phẩm</button>
</form>
<form action="/chuyen-trang/khach-hang" method="Get">
    <button type="submit">Khách hàng</button>
</form>
<form action="/chuyen-trang/mau-sac" method="Get">
    <button type="submit">Màu sắc</button>
</form>
<form action="/chuyen-trang/nha-san-xuat" method="Get">
    <button type="submit">Nhà sản xuất</button>
</form>
<form action="/chuyen-trang/nhan-vien" method="Get">
    <button type="submit">Nhân Viên</button>
</form>
<form action="/chuyen-trang/san-pham" method="Get">
    <button type="submit">Sản phẩm</button>
</form>
<form action="/cua-hang/add-ch" method="POST">

    <div>
        ma: <input type="text" name="ma" value="${maId.ma}" style="" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        ten : <input type="text" name="ten" value="${maId.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        diaChi : <input type="text" name="diaChi" value="${maId.diaChi}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        thanhPho  : <input type="text" name="thanhPho" value="${maId.thanhPho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        quocGia  : <input type="text" name="quocGia" value="${maId.quocGia}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <button type="submit">Add</button>
</form>


<table border="2">
    <thead>
    <tr>
        <th>Id</th>
        <th>ma</th>
        <th>Ten</th>
        <th>Dia Chi</th>
        <th>ThanhPho</th>
        <th>Quoc Gia</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiCh}" var="ch">
        <tr>
            <td>${ch.id}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <a href="/cua-hang/detail-ch?maCh=${ch.id}">Detail</a>
                <a href="/cua-hang/view-update-ch?maCh=${ch.id}">Edit</a>
                <a href="/cua-hang/delete-ch?maCh=${ch.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
