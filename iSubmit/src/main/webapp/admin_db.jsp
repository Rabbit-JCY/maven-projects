<%--
  Created by IntelliJ IDEA.
  User: rabbit
  Date: 04/01/2023
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin_dashboard</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        function timestampToTime(times) {
            var date = new Date(times);
            Y = date.getFullYear() + '-';
            M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
            return Y+M+D;
        }

        $(document).ready(function(){

            $("#out").click(function (){
                // alert("log out...")
                window.location.replace("login.jsp");
            });

            $.ajax({
                url: "/getPrice",
                type: "post",
                contentType: "application/json",
                success: function (res){
                    $("#day").append(res[0]["rate"]);
                    $("#night").append(res[1]["rate"]);
                    $("#gas").append(res[2]["rate"]);
                    $("#charge").append(res[3]["rate"]);

                    $("#set_day").val(res[0]["rate"]);
                    $("#set_night").val(res[1]["rate"]);
                    $("#set_gas").val(res[2]["rate"]);
                    $("#set_charge").val(res[3]["rate"]);
                }
            })

            $.ajax({
                url: '/getAll',
                type: 'post',
                contentType:"application/json",
                success: function (res) {
                    var records = res;
                    for (var i = 0; i < records.length; i++) {
                        var tr = $("<tr align='center'>" +
                            "<td>" + records[i]["reading_id"] + "</td>" +
                            "<td>" + records[i]["customer_id"] + "</td>" +
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
                url: '/getStatistics',
                type: 'post',
                contentType:"application/json",
                success: function (res) {
                    var records = res;
                    for (var i = 0; i < records.length; i++) {
                        var tr = $("<tr align='center'>" +
                            "<td>" + records[i]["customer_id"] + "</td>" +
                            "<td>" + records[i]["avg_ele_day"] + "</td>" +
                            "<td>" + records[i]["avg_ele_night"] + "</td>" +
                            "<td>" + records[i]["avg_gas"] + "</td>" +
                            "</tr>");
                        var table = $("#view_tb2");
                        table.append(tr);
                    }
                }
            })

            $("#submit").click(function (){
                var params={
                    "electricity_day" : $("#set_day").val(),
                    "electricity_night" : $("#set_night").val(),
                    "gas" : $("#set_gas").val(),
                    "sanding_charge" : $("#set_charge").val()
                }
                $.ajax({
                    url:"/setPrice",
                    type: 'post',
                    contentType:"application/json",
                    data:JSON.stringify(params),
                    success: function (res) {
                        alert(res.toString());
                        window.location.reload();
                    }
                })
            })
        });

    </script>
</head>

<body>

<h2 align="center">Welcome to the admin page.</h2><br>
<div align="right">
    <input type="button" value="log out" id="out" style="height:20px;width:50px;background-color: aqua">
</div><hr>

<h3 align="center">Please change the price of the charge in the form below.</h3>
<table id="taiff_tb" border="1" style="width: 20%" align="center">
    <thead id="taiff_td" bgcolor="#f0f8ff">
    <th>type</th>
    <th>cur_price/kWh</th>
    <th>set_price/kWh</th>
    </thead>

    <tbody align="center">
    <tr>
        <td>ele_day_price</td>
        <td id="day"></td>
        <td><input type="number" min="0" id="set_day"></td>
    </tr>
    <tr>
        <td>ele_night_price</td>
        <td id="night"></td>
        <td><input type="number" min="0" id="set_night"></td>
    <tr>
        <td>gas_price</td>
        <td id="gas"></td>
        <td><input type="number" min="0" id="set_gas"></td>
    </tr>
    <tr>
        <td>standing_charge</td>
        <td id="charge"></td>
        <td><input type="number" min="0" id="set_charge"></td>
    </tr>
    <tr>
        <td width="100"  colspan="3" align="center">
            <input type="button" value="submit" id="submit" style="background-color: azure">
        </td>
    </tr>
    </tbody>

</table>
<br>
<hr>
<h3 align="center">All the customers' readings are here.</h3>
<table id="view_tb" border="1" style="width: 80%" align="center">
    <thead id="thead" bgcolor="#f0f8ff">
    <th>Reading_id</th>
    <th>Customer_id</th>
    <th>Submission_date</th>
    <th>Readings_day</th>
    <th>Readings_night</th>
    <th>Readings_gas</th>
    <th>Status</th>
    </thead>
</table>
<br>
<hr>
<br>
<h3 align="center">All the energy statistics are here.</h3>
<h4 align="center">Note: 2023-1-10 to 2023-1-11 will be calculated as 2 days.</h4>
<table id="view_tb2" border="1" style="width: 60%" align="center">
    <thead id="thead2" bgcolor="#f0f8ff">
    <th>Customer_id</th>
    <th>Ele_day_per_day : kWh</th>
    <th>Ele_night_per_night : kWh</th>
    <th>Gas_per_day : kWh</th>
    </thead>
</table>
<br>
</body>
</html>
