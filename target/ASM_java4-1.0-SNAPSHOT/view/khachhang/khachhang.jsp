<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:56 PM
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
<form action="/chuyen-trang/san-pham" method="Get">
    <button type="submit">Sản phẩm</button>
</form>
<form action="/khach-hang/add-kh" method="POST">

    <div>
        Ma  : <input type="text" name="ma" value="${maId.ma}" style=" margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        ten : <input type="text" name="ten" value="${maId.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        tenDem: <input type="text" name="tenDem" value="${maId.tenDem}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        ho: <input type="text" name="ho" value="${maId.ho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        ngaySinh : <input type="text" name="ngaySinh" value="${maId.ngaySinh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        sdt : <input type="text" name="sdt" value="${maId.sdt}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        diaChi: <input type="text" name="sddiaChi" value="${maId.diaChi}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        ThanhPho: <input type="text" name="thanhPho" value="${maId.thanhPho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        quocGia: <input type="text" name="quocGia" value="${maId.quocGia}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        matkhau: <input type="text" name="matKhau" value="${maId.matKhau}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <button type="submit">Add</button>
</form>


<table border="2">
    <thead>
    <tr>
        <th>Ma</th>
        <th>ten</th>
        <th>tenDem</th>
        <th>ho</th>
        <th>ngaySinh</th>
        <th>sdt</th>
        <th>diaChi</th>
        <th>ThanhPho</th>
        <th>quocGia</th>
        <th>matKhau</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiKh}" var="kh">
        <tr>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a href="/khach-hang/detail-kh?maKh=${kh.id}">Detail</a>
                <a href="/khach-hang/view-update-kh?maKh=${kh.id}">Edit</a>
                <a href="/khach-hang/delete-kh?maKh=${kh.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
