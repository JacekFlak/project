<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        <%@include file="/resources/css/style.css" %>
    </style>
    <title><s:message code="menu.mainPage"/></title>
</head>
<body>

<%@include file="/WEB-INF/incl/menu.app" %>

<h2 align="center"><s:message code="info.title"/></h2>

<h3 align="center"><s:message code="info.author"/></h3>

<%--<img src="/resources/images/github.jpg" onclick="github.com/JacekFlak/project"/>--%>

</body>
</html>