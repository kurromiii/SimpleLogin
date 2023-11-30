<%@ page import="com.mftplus.simplelogin.model.entity.User" %>
<%@ page import="com.mftplus.simplelogin.model.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/30/2023
  Time: 1:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userList</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        .table-row:hover {
            background-color: #4b4b4b;
            color: white;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Family</th>
        <th>Username</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <%for (User user : UserService.getUserService().findAll()) {%>
    <tr class="table-row">
        <td>
            <%=user.getId()%>
        </td>
        <td>
            <%=user.getName()%>
        </td>
        <td>
            <%=user.getFamily()%>
        </td>
        <td>
            <%=user.getUserName()%>
        </td>
        <td>
            <%=user.getPassWord()%>
        </td>

    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
