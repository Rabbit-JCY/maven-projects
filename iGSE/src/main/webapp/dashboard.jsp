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
            $("#out").click(function (){
                alert("log out...")
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
                        alert("submit successfully!");
                    }
                })
            });

            $("#check").click(function () {
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
                            var $tr = $("<tr>" +
                                "<td>" + records[i]["reading_id"] + "</td>" +
                                "<td>" + timestampToTime(records[i]["submission_date"]) + "</td>" +
                                "<td>" + records[i]["elec_readings_day"] + "</td>" +
                                "<td>" + records[i]["elet_reading_night"] + "</td>" +
                                "<td>" + records[i]["gas_reading"] + "</td>" +
                                "<td>" + records[i]["status"]+ "</td>" +
                                "</tr>");
                            var $table = $("#view_tb");
                            $table.append($tr);
                        }
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
        <td><input type="number" min="0" id="day" name="day"></td>
    </tr>
    <tr>
        <td>ele_night</td>
        <td><input type="number" min="0" id="night" name="night"></td>
    <tr>
        <td>gas</td>
        <td><input type="number" min="0" id="gas" name="gas"></td>
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
<h4 align="center">Please click [check] if you want to check all your readings.</h4>
<h4 align="center">Please click it again if you submit a new reading or pay a bill.</h4>

<div align="center">
<input type="button" value="check" id="check" style="height:20px;width:50px;background-color: aqua" align="center">
</div>

<br>
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
<table border="1" align="center">
    <tbody>
    <tr>
        <td>
            reading_id:
        </td>
        <td>
            <input type="number" id="pay_id">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="pay" id="pay_bt" style="background-color: azure">
        </td>
    </tr>
    </tbody>
</table>


</body>
</html>