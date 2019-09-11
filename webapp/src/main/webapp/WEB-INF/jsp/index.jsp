<%--
  Created by IntelliJ IDEA.
  User: flakj
  Date: 10.09.2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<link href="<mvc:url value="/webapp/src/main/frontend/static/css/style.css" />" rel="stylesheet">


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
  <title>Aplikacja</title>
</head>
<body>

<div class="custom-menu-wrapper">
  <div class="pure-menu custom-menu custom-menu-top">
    <a href="#" class="pure-menu-heading custom-menu-brand">Brand</a>
    <a href="#" class="custom-menu-toggle" id="toggle"><s class="bar"></s><s class="bar"></s></a>
  </div>
  <div class="pure-menu pure-menu-horizontal pure-menu-scrollable custom-menu custom-menu-bottom custom-menu-tucked" id="tuckedMenu">
    <div class="custom-menu-screen"></div>
    <ul class="pure-menu-list">
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Home</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">About</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Contact</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Blog</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">GitHub</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Twitter</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Apple</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Google</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Wang</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">Yahoo</a></li>
      <li class="pure-menu-item"><a href="#" class="pure-menu-link">W3C</a></li>
    </ul>
  </div>
</div>

<script type="">
  (function (window, document) {
    document.getElementById('toggle').addEventListener('click', function (e) {
      document.getElementById('tuckedMenu').classList.toggle('custom-menu-tucked');
      document.getElementById('toggle').classList.toggle('x');

    });
  })(this, this.document);
</script>

</body>

</html>
