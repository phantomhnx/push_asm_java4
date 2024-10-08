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

<form action="/chuyen-trang/chi-tiet-sp" method="Get">
    <button type="submit">Chi  tiết sản phẩm</button>
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

<form action="/chuc-vu/add-cv" method="POST">
    <div>
       Id : <input type="text" name="id" value="${maId1.id}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
       Ma : <input type="text" name="ma" value="${maId1.ma}"style=" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
       Ten : <input type="text" name="ten" value="${maId1.ten}" style="margin-bottom: 10px;"/>
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
    <c:forEach items="${hienThiCv}" var="cv">
        <tr>
            <td>${cv.id}</td>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>
            <td>
                <a href="/chuc-vu/detail-cv?maId=${cv.id}">Detail</a>
                <a href="/chuc-vu/view-update-cv?maId=${cv.id}">Edit</a>
                <a href="/chuc-vu/delete-cv?maId=${cv.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
