<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/nhan-vien/update-nv" method="POST">
    <div>
        ma : <input type="text" name="ma" value="${maId1.ma}" style=" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        ten  : <input type="text" name="ten" value="${maId1.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        tenDem : <input type="text" name="tenDem" value="${maId1.tenDem}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        ho  : <input type="text" name="ho" value="${maId1.ho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        gioiTinh: <input type="text" name="gioiTinh" value="${maId1.gioiTinh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        ngaySinh: <input type="text" name="ngaySinh" value="${maId1.ngaySinh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        diaChi : <input type="text" name="diaChi" value="${maId1.diaChi}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <div>
        sdt  : <input type="text" name="sdt" value="${maId1.sdt}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        matKhau  : <input type="text" name="matKhau" value="${maId1.matKhau}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idCh : <input type="text" name="idCh" value="${maId1.idCh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idCv : <input type="text" name="idCv" value="${maId1.idCv}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idGuiBc  : <input type="text" name="idGuiBc" value="${maId1.idGuiBc}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        trangThai : <input type="text" name="trangThai" value="${maId1.trangThai}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <button type="submit">Update</button>
</form>
</body>
</html>
