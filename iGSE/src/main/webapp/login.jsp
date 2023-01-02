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
                    localStorage.setItem("email",$("#eml").val());
                    localStorage.setItem("credit", "1000");
                    window.location.replace("dashboard.jsp");

                }
            });
        })

        $("#register").click(function() {
            window.location.replace("register.jsp");
        })

    });
</script>

<body>
<h1>Login</h1>

email:       <input type="text" name="email" id="eml"><br>
password:    <input type="password" name="password" id="pwd"><br>

<input type="button" value="log in" id="login">
<input type="button" value="register" id="register">


</body>

</html>
