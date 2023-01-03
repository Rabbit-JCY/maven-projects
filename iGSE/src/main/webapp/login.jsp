<%--
  Created by IntelliJ IDEA.
  User: rabbit
  Date: 29/12/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script>
    localStorage.setItem("email","test@gmail.com")
    $(document).ready(function(){
        $("#login").click(function(){
            // alert("log in");
            var params = {
                "email" : $("#eml").val(),
                "password" : $("#pwd").val()
            }

            $.ajax({
                url:"/login",
                type:"Post",
                contentType:"application/json",
                data:JSON.stringify(params),
                success:function (result) {
                    if(result.toString() == "success"){
                        localStorage.setItem("email",$("#eml").val());
                        window.location.replace("dashboard.jsp");
                    }else{
                        alert(result.toString());
                    }


                }
            });
        })

        $("#register").click(function() {
            window.location.replace("register.jsp");
        })

    });
</script>

<body>
<br>
<h2 align="center">Welcome to the login page.</h2><br>
<hr>
<br><br><br><br><br>
<h3 align="center">
    iGSE – An Energy Tool
</h3>
<table border="1" align="center" style="width: 20%">
    <tbody align="center">
    <tr>
        <td style="background-color: aliceblue">
            email:
        </td>
        <td>
            <input type="text" name="email" id="eml">
            <script>
                $("#eml").val(localStorage.getItem("email"))
            </script>
        </td>
    </tr>
    <tr>
        <td style="background-color: aliceblue">
            password:
        </td>
        <td>
            <input type="password" name="password" id="pwd">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="log in" id="login" style="background-color: azure;width: 80px">
            <input type="button" value="register" id="register" style="background-color: azure;width: 80px">
        </td>
    </tr>
    </tbody>
</table>


</body>

</html>
