<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Register</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){

            $("#bt").click(function(){
                alert("send request");
                var customer={
                    "customer_id" : $("#email").val(),
                    "password_hash" : $("#pwd").val(),
                    "address": $("#ads").val(),
                    "property_type": $("#pt").val(),
                    "bedroom_num": $("#bn").val(),
                    "balance": $("#bal").val(),
                    "type": $("#tp").val()
                };
                $.ajax({
                    url:"/register",
                    type:"Post",
                    contentType:"application/json",
                    data:JSON.stringify(customer),
                    success:function (result) {
                        alert(result["customer_id"]);
                        window.location.replace("login.jsp");

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

<form>
    email address: <input type="text" id="email" name="customer_id" id="email" placeholder="email address"><br>
    password:      <input type="password" name="password_hash" id="pwd" placeholder="password"><br>
    address:       <input type="test" name="address" id="ads" placeholder="address"><br>
    property_type: <input type="text" name="property_type" id="pt"><br>
    bedroom_num:   <input type="number" name="bedroom_num" id="bn"><br>
    balance:       <input type="number" name="balance" id="bal"><br>
    type:          <input type="text" name="type" id="tp"><br>
    <input type="button" value="register" id="bt">
    <input type="button" value="return" id="return">


<%--    <div id="div1">--%>
<%--        <h2>使用 jQuery AJAX 修改文本内容</h2>--%>
<%--    </div>--%>
</form>

</body>
</html>
