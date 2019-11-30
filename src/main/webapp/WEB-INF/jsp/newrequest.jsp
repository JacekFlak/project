<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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

    <title><s:message code="menu.newRequest"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="menu.newRequest"/></h2>

<p align="center">
    <a> <c:out value="${message}"/> </a>
</p>

<sf:form id="requestsForm" action="addrequest" modelAttribute="request"
         enctype="multipart/form-data" method="POST">

    <table width="500" border="0" cellpadding="4" cellspacing="1"
           align="center">

        <tr>
            <td width="130" align="right"><s:message code="request.store"/></td>
            <td width="270" align="left"><select>
                <option value="11"></option>
                <option value="22"></option>
                <option value="33"></option>
            </select>
            </td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="request.product"/></td>

            <td width="270" align="left"><select>
                <c:forEach var="p" items="${productList}">
                    <c:out value="${p.name }"/>
                </c:forEach>
            </select></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="request.quantity"/></td>
            <td width="270" align="left"><sf:input path="quantity" size="28" id="name"/></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="request.description"/></td>
            <td width="270" align="left"><sf:input path="description" size="28" id="name"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="<s:message code="button.create.request"/>" class="btn-two green rounded"/>
                <input type="button" value="<s:message code="button.cancel"/>" class="btn-two red rounded"/>
            </td>
        </tr>

    </table>
</sf:form>
</body>
</html>