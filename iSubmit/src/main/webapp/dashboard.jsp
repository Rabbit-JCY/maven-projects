<%@ page contentType="text/html;Charset=utf-8" language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Dashboard</title>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        function timestampToTime(times) {
            var date = new Date( times);
            Y = date.getFullYear() + '-';
            M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
            return Y+M+D;
        }

        function cleanView(){
            var tb = document.getElementById('view_tb');
            var rowNum=tb.rows.length;
            for (var i=rowNum; i > 1; i--)
            {
                tb.deleteRow(i-1);
            }
        }

        $(document).ready(function(){
            var p={
                "customer_id" : localStorage.getItem("email")
            }
            $.ajax({
                url:"/getBalance",
                type:"Post",
                contentType:"application/json",
                data:JSON.stringify(p),
                success:function (result) {
                    var td = $("#balance");
                    td.append(result.toString());
                }
            });

            var params = {
                "customer_id": localStorage.getItem("email")
            };
            $.ajax({
                url: '/getByCustomerId',
                type: 'post',
                contentType:"application/json",
                data: JSON.stringify(params),
                success: function (res) {
                    var records = res;
                    cleanView();
                    for (var i = 0; i < records.length; i++) {
                        var tr = $("<tr>" +
                            "<td>" + records[i]["reading_id"] + "</td>" +
                            "<td>" + timestampToTime(records[i]["submission_date"]) + "</td>" +
                            "<td>" + records[i]["elec_readings_day"] + "</td>" +
                            "<td>" + records[i]["elet_reading_night"] + "</td>" +
                            "<td>" + records[i]["gas_reading"] + "</td>" +
                            "<td>" + records[i]["status"]+ "</td>" +
                            "</tr>");
                        var table = $("#view_tb");
                        table.append(tr);
                    }
                }
            })

            $.ajax({
                url: '/energy_report/' + $("#quarter").val(),
                type: 'GET',
                contentType:"application/json",
                success: function (res) {
                    var records = res["list"];
                    for (var i = 0; i < records.length; i++) {
                        if(records[i]["renewable"] == true){
                            var content = $(
                                "<li>" + records[i]["source"] + " : " + records[i]["output"] + "</li>")
                            var div = $("#result");
                            div.append(content);
                        }
                    }
                }
            })

            $("#out").click(function (){
                // alert("log out...")
                window.location.replace("login.jsp");
            });

            $("#submit").click(function() {
                var params={
                    "customer_id":localStorage.getItem("email"),
                    "elec_readings_day":$("#day").val(),
                    "elet_reading_night":$("#night").val(),
                    "gas_reading":$("#gas").val()
                }
                $.ajax({
                    url:"/submit",
                    type:"Post",
                    contentType:"application/json",
                    data:JSON.stringify(params),
                    success:function (result) {
                        alert(result.toString());
                        location.reload();
                    }
                })
            });

            $("#pay_bt").click(function (){
                var params = {
                    "reading_id": $("#pay_id").val(),
                    "customer_id": localStorage.getItem("email")
                };
                $.ajax({
                    url:"/pay",
                    type:"Post",
                    contentType:"application/json",
                    data:JSON.stringify(params),
                    success:function (result) {
                        alert(result.toString());
                        location.reload();
                    }
                })
            })

            $("#top_up_bt").click(function (){
                var params = {
                    "customer_id": localStorage.getItem("email"),
                    "EVC_code": $("#EVC_code2").val()
                };
                $.ajax({
                    url:"/top_up",
                    type:"Post",
                    contentType:"application/json",
                    data:JSON.stringify(params),
                    success:function (result) {
                        alert(result.toString());
                        location.reload();
                    }
                })
            })

        })
    </script>

</head>

<body>

<h2 align="center">Login successfully, welcome to the customer page!</h2>

<div align="right">
<input type="button" value="log out" id="out" style="height:20px;width:50px;background-color: aqua">
</div><hr>

<h4 align="center">Please submit your latest reading in the following form:</h4>
<table id="reading_tb" border="1" style="width: 20%" align="center">
    <thead id="reading_td" bgcolor="#f0f8ff">
    <th>item</th>
    <th>data: kWh</th>
    </thead>

    <tbody align="center">
    <tr>
        <td>ele_day</td>
        <td><input type="number" min="0" id="day" name="day" value="0.0"></td>
    </tr>
    <tr>
        <td>ele_night</td>
        <td><input type="number" min="0" id="night" name="night" value="0.0"></td>
    <tr>
        <td>gas</td>
        <td><input type="number" min="0" id="gas" name="gas" value="0.0"></td>
    </tr>
    <tr>
        <td width="100"  colspan="2" align="center">
            <input type="button" value="submit" id="submit" style="background-color: azure">
        </td>
    </tr>
    </tbody>

</table>

<br>
<hr>
<h4 align="center">Here are your readings.</h4>
<table id="view_tb" border="1" style="width: 50%" align="center">
    <thead id="thead" bgcolor="#f0f8ff">
    <th>Reading_id</th>
    <th>Submission_date</th>
    <th>Readings_day</th>
    <th>Readings_night</th>
    <th>Readings_gas</th>
    <th>Status</th>
    </thead>
</table>
<br>
<hr>
<h4 align="center">Please choose a reading_id and pay for it.</h4>
<table name="pay_tb" border="1" align="center">
    <tbody>
    <tr>
        <td align="center" style="background-color: aliceblue">
            balance
        </td>
        <td align="center" id="balance">

        </td>
    </tr>
    <tr>
        <td align="center" style="background-color: aliceblue">
            reading_id
        </td>
        <td>
            <input type="number" id="pay_id" placeholder="reading_id">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="pay" id="pay_bt" style="background-color: azure">
        </td>
    </tr>
    </tbody>
</table>
<br>
<hr>
<h4 align="center">Please top up your account with a valid EVC_code.</h4>
<table name="top_up_tb" border="1" align="center">
    <tbody>
    <tr>
        <td align="center" style="background-color: aliceblue">
            EVC_code
        </td>
        <td>
            <input type="text" id="EVC_code2" placeholder="EVC_code">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="top up" id="top_up_bt" style="background-color: azure">
        </td>
    </tr>
    </tbody>
</table>
<br>


</body>
</html>