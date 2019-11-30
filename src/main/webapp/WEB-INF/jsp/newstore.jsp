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
    <title><s:message code="menu.newStore"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="menu.newStore"/></h2>

<a align="center">
    <a><c:out value="${message}"/></a>
</p>

<sf:form id="storesForm" action="addstore" modelAttribute="store"
         enctype="multipart/form-data" method="POST">

    <table width="500" border="0" cellpadding="4" cellspacing="1"
           align="center">

        <tr>
            <td width="130" align="right"><s:message code="store.name"/></td>
            <td width="270" align="left"><sf:input path="name" size="28" id="name"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="name"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.street"/></td>
            <td width="270" align="left"><sf:input path="street"
                                                   size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="street"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.number"/></td>
            <td width="270" align="left"><sf:input path="number" size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="number"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.city"/></td>
            <td width="270" align="left"><sf:input path="city" size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="city"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.country"/></td>
            <td width="270" align="left"><sf:input path="country" size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="country"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.email"/></td>
            <td width="270" align="left"><sf:input path="email" size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="email"/></span></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="store.phone"/></td>
            <td width="270" align="left"><sf:input path="phone" size="28"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><span style="color: red; "><sf:errors path="phone"/></span></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="<s:message code="button.add.store"/>" class="btn-two green rounded"/>
                <input type="button" value="<s:message code="button.cancel"/>" class="btn-two red rounded"
                       onclick="window.location.href='${pageContext.request.contextPath}/'"/>
            </td>
        </tr>

    </table>

</sf:form>

</body>
</html>