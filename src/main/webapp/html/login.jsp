<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="../assets/css/register.css">
</head>
<body>
<table width="100%" border="1px" cellspacing="0px" cellpadding="10px">
    <tr >
        <td colspan="4" bgcolor="black">
            <h1 align="center" style="color: blueviolet">
                <em>Welcome to our website!</em>
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
            <a href="#" style="color: black">login</a>
        </td>
        <td bgcolor="#8a2be2">
            <a href="/html/admin.jsp" style="color: black">Admin</a>
        </td>
    </tr>
    <tr bgcolor="#4b0082">
        <td colspan="4">
            <br>
            <h2 align="center">Enter your information to login</h2>
            <form action="/login.do" method="post">
                <br/>
                <label for="userId"></label>
                <p align="center"><input id="userId" type="text" name="userName" placeholder="Username" value="${cookie.userName.value}"></p>
                <label for="passId"></label>
                <p align="center"><input id="passId" type="password" name="passWord" placeholder="Password" value="${cookie.passWord.value}"></p>
                <br/>
                <p align="center">Remember me!</p>
                <p align="center"><input type="checkbox" name="remember"></p>
                <br/>
                <p align="center"><input type="submit" value="login"></p>
                <br/>
                <h4 align="center"><i>Not a member?</i></h4>
                <h4 align="center"><i><a href="register.html" style="color: black">Register now</a></i></h4>
                <br><br><br>
            </form>
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