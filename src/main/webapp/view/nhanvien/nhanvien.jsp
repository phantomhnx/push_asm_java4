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
<form action="/chuyen-trang/nha-san-xuat" method="Get">
    <button type="submit">Nhà sản xuất</button>
</form>
<form action="/chuyen-trang/san-pham" method="Get">
    <button type="submit">Sản phẩm</button>
</form>
<form action="/nhan-vien/add-nv" method="POST">

    <div>
        ma : <input type="text" name="ma" value="${maId.ma}" style=" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        ten  : <input type="text" name="ten" value="${maId.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        tenDem : <input type="text" name="tenDem" value="${maId.tenDem}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        ho  : <input type="text" name="ho" value="${maId.ho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        gioiTinh: <input type="text" name="gioiTinh" value="${maId.gioiTinh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        ngaySinh: <input type="text" name="ngaySinh" value="${maId.ngaySinh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        diaChi : <input type="text" name="diaChi" value="${maId.diaChi}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        sdt  : <input type="text" name="sdt" value="${maId.sdt}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        matKhau  : <input type="text" name="matKhau" value="${maId.matKhau}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idCh : <input type="text" name="idCh" value="${maId.idCh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idCv : <input type="text" name="idCv" value="${maId.idCv}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idGuiBc  : <input type="text" name="idGuiBc" value="${maId.idGuiBc}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        trangThai : <input type="text" name="trangThai" value="${maId.trangThai}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <button type="submit">Add</button>
</form>


<table border="2">
    <thead>
    <tr>
        <th>ma</th>
        <th>ten</th>
        <th>tenDem</th>
        <th>ho</th>
        <th>gioiTinh</th>
        <th>ngaySinh</th>
        <th>diaChi</th>
        <th>sdt</th>
        <th>matKhau</th>
        <th>idCh</th>
        <th>idCv</th>
        <th>idGuiBc</th>
        <th>trangThai</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiNv}" var="nv">
        <tr>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.idCh}</td>
            <td>${nv.idCv}</td>
            <td>${nv.idGuiBc}</td>
            <td>${nv.trangThai}</td>

            <td>
                <a href="/nhan-vien/detail-nv?maNv=${nv.id}">Detail</a>
                <a href="/nhan-vien/view-update-nv?maNv=${nv.id}">Edit</a>
                <a href="/nhan-vien/delete-nv?maNv=${nv.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
