<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>Aplikacja</title>
</head>
<body>

<form action="Sum">

    Type a:<br>
    <input type="text" name="a" id="firstValue" placeholdr="a value">
    <!-- int a = document.getElementById("firstValue").value;-->
    <br>

    Type b <br>
    <input type="text" name="b" id="secondValue" placeholder="b value">
    <!-- int b = document.getElementById("secondValue").value; -->
    <br>

    <button class="sum button">Calculate</button>
    <br>
    Result:
    <input type="text" name="sum result"><br>

</form>
</body>
</html>
