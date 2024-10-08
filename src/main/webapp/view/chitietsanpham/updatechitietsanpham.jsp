<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/chi-tiet-san-pham/update-ct?mct=${mct1.id}" method="POST">

    <div>
        id : <input type="text" name="id" value="${mct1.id}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idSp : <input type="text" name="idSp" value="${mct1.idSp}" style="margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        idNsx : <input type="text" name="idNsx" value="${mct1.idNsx}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        idMauSac  : <input type="text" name="idMauSac" value="${mct1.idMauSac}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        idDongSp  : <input type="text" name="idDongSp" value="${mct1.idDongSp}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        namBh  : <input type="text" name="namBh" value="${mct1.namBh}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        mota  : <input type="text" name="moTa" value="${mct1.moTa}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        soLuongTon  : <input type="text" name="soLuongTon" value="${mct1.soLuongTon}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        giaNhap  : <input type="text" name="giaNhap" value="${mct1.giaNhap}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        giaBan  : <input type="text" name="giaBan" value="${mct1.giaBan}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
