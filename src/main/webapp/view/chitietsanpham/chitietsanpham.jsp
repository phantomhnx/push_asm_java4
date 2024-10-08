<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="from-inline" style="display: inline">
    <form action="/chuyen-trang/chuc-vu" method="Get">
        <button type="submit">Chức vụ</button>
    </form>
    <form action="/chuyen-trang/cua-hang" method="Get">
        <button type="submit">Cửa hàng</button>
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
</div>


</br>
<form action="/chi-tiet-san-pham/add-ct" method="POST">
    <div>
        id : <input type="text" name="id" value="${mct.id}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idSp : <input type="text" name="idSp" value="${mct.idSp}" style="margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        idNsx : <input type="text" name="idNsx" value="${mct.idNsx}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idMauSac  : <input type="text" name="idMauSac" value="${mct.idMauSac}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        idDongSp  : <input type="text" name="idDongSp" value="${mct.idDongSp}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        namBh  : <input type="text" name="namBh" value="${mct.namBh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        mota  : <input type="text" name="moTa" value="${mct.moTa}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        soLuongTon  : <input type="text" name="soLuongTon" value="${mct.soLuongTon}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        giaNhap  : <input type="text" name="giaNhap" value="${mct.giaNhap}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        giaBan  : <input type="text" name="giaBan" value="${mct.giaBan}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <button type="submit">Add</button>
</form>


<table border="2">
    <thead>
    <tr>
        <th>id</th>
        <th>idSp</th>
        <th>idNsx</th>
        <th>idMauSac</th>
        <th>idDongSp</th>
        <th>namBh</th>
        <th>moTa</th>
        <th>soLuongTon</th>
        <th>giaNhap</th>
        <th>giaBan</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiCt}" var="ct">
        <tr>
            <td>${ct.id}</td>
            <td>${ct.idSp}</td>
            <td>${ct.idNsx}</td>
            <td>${ct.idMauSac}</td>
            <td>${ct.idDongSp}</td>
            <td>${ct.namBh}</td>
            <td>${ct.moTa}</td>
            <td>${ct.soLuongTon}</td>
            <td>${ct.giaNhap}</td>
            <td>${ct.giaBan}</td>
            <td>
                <a href="/chi-tiet-san-pham/detail-ct?mct=${ct.id}">Detail</a>
                <a href="/chi-tiet-san-pham/view-update-ct?mct=${ct.id}">Edit</a>
                <a href="/chi-tiet-san-pham/delete-ct?mct=${ct.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
