<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        <%@include file="/resources/css/style.css" %>
    </style>
    <title><s:message code="menu.requests"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<div align="right">
    <s:message code="user.loginAs"/>
    <c:out value="${user.email }"/>
</div>
<h2><s:message code="menu.newRequest"/></h2>

<p align="center">
    <c:out value="${message }"/>
</p>

<%--<sf:form id="requestForm" action="createRequest" modelAttribute="request" enctype="multipart/form-data" method="POST">--%>

<table width="500" border="0" cellpadding="4" cellspacing="1"
       align="center">

    <tr>
        <td width="130" align="right"><s:message code="request.name"/></td>
        <td width="270" align="left"><sf:input path="name" size="28" id="name"/></td>
    </tr>

    <tr>
        <td width="130" align="right"><s:message code="request.product"/></td>

    </tr>

    <tr>
        <td width="130" align="right"><s:message code="request.responsible"/></td>

    </tr>

    <tr>
        <td colspan="2" align="center" bgcolor="#fff">
            <input type="submit" value="<s:message code="button.create.request"/>" class="formbutton"/>
            <input type="button" value="<s:message code="button.cancel"/>" class="formbutton"
            <%--onclick="window.location.href='${pageContext.request.contextPath}/'"--%>/>
        </td>
    </tr>

</table>

<%--</sf:form>--%>

</body>
</html>