<%--
  Created by IntelliJ IDEA.
  User: Phan Cao
  Date: 4/4/2024
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/cua-hang/update-ch" method="POST">
    <div>
        id : <input type="text" name="id" value="${maId1.id}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        ma: <input type="text" name="ma" value="${maId1.ma}" style="" margin-bottom: 10px;"/>
        <br/>
    </div>


    <div>
        ten : <input type="text" name="ten" value="${maId1.ten}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        diaChi : <input type="text" name="diaChi" value="${maId1.diaChi}" style="margin-bottom: 10px;"/>
        <label></label>
        <br/>
    </div>

    <div>
        thanhPho  : <input type="text" name="thanhPho" value="${maId1.thanhPho}" style="margin-bottom: 10px;"/>
        <br/>
    </div>

    <div>
        quocGia  : <input type="text" name="quocGia" value="${maId1.quocGia}" style="margin-bottom: 10px;"/>
        <br/>
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
