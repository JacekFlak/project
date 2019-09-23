<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>Aplikacja</title>

</head>
<body>

<script type="text/javascript">
    function sumValues() {
        var a = parseFloat(document.getElementById('firstValue').value);
        var b = parseFloat(document.getElementById('secondValue').value);
        var total = a + b;
        document.getElementById('sumResult').innerHTML = total.toString();
    }
</script>

<form action="Sum">
    Type a:<br>
    <input type="text" name="a" id="firstValue" placeholder="a value"><br>

    Type b:<br>
    <input type="text" name="b" id="secondValue" placeholder="b value"><br>

    <button name="sumButton" onClick="sumValues()">Calculate</button>
    <br>
    <div id="sumResult"> d<script> sumValues();</script>
    </div>
</form>
</body>
</html>
