<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Register</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){

            $("#bt").click(function(){
                // alert("send request");
                var EVC_code={
                    "EVC_code" : $("#EVC_code").val()
                }
                $.ajax({
                    url:"/checkCode",
                    type:"Post",
                    contentType:"application/json",
                    data:JSON.stringify(EVC_code),
                    success:function (result) {
                        if(result.toString() == "success"){
                            alert("Code is valid.")
                            var customer={
                                "customer_id" : $("#email").val(),
                                "password_hash" : $("#pwd").val(),
                                "address": $("#ads").val(),
                                "property_type": $("#p_type").val(),
                                "bedroom_num": $("#bn").val(),
                                "balance": 200,
                                "type": "customer"
                            };
                            $.ajax({
                                url:"/register",
                                type:"Post",
                                contentType:"application/json",
                                data:JSON.stringify(customer),
                                success:function (result) {
                                    if(result.toString() === "success"){
                                        var params={
                                            "EVC_code": $("#EVC_code").val()
                                        }
                                        $.ajax({
                                            url:"/useCode",
                                            type:"Post",
                                            contentType:"application/json",
                                            data:JSON.stringify(params),
                                            success: function (data){
                                                alert(data.toString());
                                            }
                                        })
                                        alert("Register successfully!")
                                        window.location.replace("login.jsp");
                                    }else{
                                        alert("Fail. " + result.toString());
                                    }
                                }

                            })
                        }else{
                            alert(result.toString());
                        }

                    }
                })

            });

            $("#return").click(function (){
                window.location.replace("login.jsp");
            });

        });
    </script>
</head>

<body>
<br>
<h2 align="center">Welcome to the register page.</h2>
<br>
<hr>
<br><br><br><br><br>
<h3 align="center">
    iGSE – An Energy Tool
</h3>
<table align="center" border="1">
    <tbody>
    <tr>
        <td>email</td>
        <td><input type="text" id="email" name="customer_id" placeholder="email"></td>
    </tr>
    <tr>
        <td>password</td>
        <td> <input type="password" name="password_hash" id="pwd" placeholder="password"></td>
    </tr>
    <tr>
        <td>address</td>
        <td><input type="text" name="address" id="ads" placeholder="address"></td>
    </tr>
    <tr>
        <td>property_type</td>
        <td>
            <select id="p_type" name="p_type">
                <option value="detached" select="selected">detached</option>
                <option value="semi-detached">semi-detached</option>
                <option value="terraced">terraced</option>
                <option value="flat">flat</option>
                <option value="cottage">cottage</option>
                <option value="bungalow">bungalow</option>
                <option value="mansion">mansion</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>bedroom_num</td>
        <td><input type="number" min="1" value="1" name="bedroom_num" id="bn" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                   onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
    </tr>
    <tr>
        <td>EVC_code</td>
        <td><input type="text" name="EVC_code" id="EVC_code"></td>
    </tr>

    <tr align="center">
        <td colspan="2">
            <input type="button" value="register" id="bt" style="background-color: azure">
            <input type="button" value="return" id="return" style="background-color: azure">
        </td>
    </tr>
    </tbody>
</table>

<form>


</form>

</body>
</html>
