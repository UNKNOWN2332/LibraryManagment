<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 07/07/22
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Cabinet</title>
</head>
<body>

<form action="/book" method="post">
    <input name="NameBook" type="text" placeholder="Name book"><br>
    <input name="Cost" type="text" placeholder="Enter cost"><br>
    <input name="genre" type="text" placeholder="Enter genre"><br>
    <input name="PageCount" type="text" placeholder="Enter page count"><br>
    <input name="TotalCount" type="text" placeholder="Enter totalCount"><br>
    <input name="LeftNumber" type="text" placeholder="Enter leftCount"><br>
    <input name="AuthorId" type="text" placeholder="Enter AuthorId"><br>
    <button type="Ok">Register</button>
</form>

</body>
</html>
