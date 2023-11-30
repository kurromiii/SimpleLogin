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
<table width="100%" border="1px" cellspacing="0px" cellpadding="10px">
    <tr >
        <td colspan="4" bgcolor="black">
            <h1 align="center">
                <em style="color: blueviolet">Welcome to our website!</em>
            </h1>
        </td>
    </tr>
    <tr align="center">
        <td bgcolor="#8a2be2" height="30px">
            <a href="/html/home.html" style="color: black">Home</a>
        </td>
        <td bgcolor="#8a2be2">
            <a href="/html/register.html" style="color: black">Register</a>
        </td>
        <td bgcolor="#8a2be2">
            <a href="/html/login.jsp" style="color: black">login</a>
        </td>
        <td bgcolor="#8a2be2">
            <a href="/html/admin.jsp" style="color: black">Admin</a>
        </td>
    </tr>
    <tr bgcolor="#4b0082">
        <td colspan="4">

            <h1 align="center">User List</h1>
            <br><br>
            <table align="center">
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
                    <td>
                        <button>remove</button>
                    </td>

                </tr>
                <%}%>
                </tbody>
            </table>
            <br><br><br><br>
        </td>
    </tr>
    <tr bgcolor="#9932cc" align="center">

        <td colspan="4">
            <h5>
                <i>
                    about us
                    <br/>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus, consequatur culpa dolor, dolorem, error itaque iure nulla obcaecati perferendis provident quaerat qui quia quidem sed sequi sit tenetur ullam vel.
                </i>
            </h5>
        </td>
    </tr>
</table>
</body>
</html>
