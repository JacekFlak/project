<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        <%@include file="/resources/css/style.css" %>
    </style>
    <title><s:message code="login.pageName"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="login.pageName"/></h2>

<form id="loginForm" action="/login" method="POST">

    <table width="350" border="0" cellpadding="4" cellspacing="1"
           align="center">
        <tr>
            <td colspan="2" align="center">

            </td>
        </tr>
        <tr>
            <td align="right" width="140">
                <s:message code="register.email"/>
            </td>
            <td align="left">
                <input type="text" name="email" id="email"
                       size="30"/>
            </td>
        </tr>
        <tr>
            <td align="right" width="140">
                <s:message code="register.password"/>
            </td>
            <td align="left">
                <input type="password" name="password" id="password" size="30"/>
            </td>
        </tr>
        <div align="center">
            <c:if test="${not empty param.error}"><br>
            <span style="color: maroon; "><strong><s:message code="error.login"/></strong></span>
            </c:if>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="<s:message code="button.login"/>" class="btn-two green rounded"/></td>
            </tr>
    </table>
</form>
<div id="copyright">
    <a><s:message code="info.title"/></a><br>
    <s:message code="info.author"/>
</div>
</body>
</html>