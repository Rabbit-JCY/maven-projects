<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Dashboard</title>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
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

                    }
                })

            })
        });
    </script>





</head>


<body>

day:     <input type="number" id="day" name="day"><br>
night:   <input type="number" id="night" name="night"><br>
gas:     <input type="number" name="gas" id="gas"><br>

<input type="button" value="submit" id="submit">

<div id="result"></div>

<script>
    document.getElementById("result").innerHTML = localStorage.getItem("name");
</script>


</body>
</html>