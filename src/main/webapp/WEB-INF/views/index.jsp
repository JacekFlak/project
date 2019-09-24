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

    function subValues() {
        var a = parseFloat(document.getElementById('firstValue').value);
        var b = parseFloat(document.getElementById('secondValue').value);
        var total = a - b;
        document.getElementById('sumResult').innerHTML = total.toString();
    }

    function clearField() {
        var blank = " ";
        document.getElementById('sumResult').innerHTML = blank;
    }
</script>

<form id="calc" name="sum" action="test" method="get">
    Type a:<br>
    <input type="text"  class="form-control" name="a" id="firstValue" placeholder="a value"><br><br>
    Type b:<br>
    <input type="text"  class="form-control" name="b" id="secondValue" placeholder="b value"><br><br>

    <input type="button" name="sumButton" class="btn btn-md btn-success btn-block" value="+"
           onClick="sumValues()">

    <input type="button" name="subButton" class="btn btn-md btn-success btn-block" value="-"
           onClick="subValues()">

    <input type="button" name="clearResult" class="btn btn-md btn-success btn-block" value="Clear"
           onClick="clearField()">
    <br>
    <div id="sumResult" value=" "></div>
</form>
</body>
</html>
