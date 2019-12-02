<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title><s:message code="profile.userData"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<div allign="center">
    <h2><s:message code="profile.userData"/></h2>
</div>

<sf:form>

<table width="300" border="1" cellpadding="4" cellspacing="1" align="center" class="userdata">

    <tr>
        <td width="130" align="right">
            <s:message code="profile.email"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.email }"/>
        </td>
    </tr>

    <tr>
        <td width="130" align="right">
            <s:message code="profile.name"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.name }"/>
        </td>
    </tr>

    <tr>
        <td width="130" align="right">
            <s:message code="profile.lastName"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.lastName }"/>
        </td>
    </tr>

    <tr>
        <td width="130" align="right">
            <s:message code="profile.isActive"/>
        </td>
        <td width="270" align="left">
            <c:choose>
                <c:when test="${user.active == 1 }">
                    <s:message code="word.yes"/>
                </c:when>
                <c:otherwise>
                    <s:message code="word.no"/>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>

    <tr>
        <td width="130" align="right">
            <s:message code="profile.role"/>
        </td>
        <td width="270" align="left">
            <c:choose>

            <c:when test="${user.nrRoli == 1 }">
                <span style="color: blue; "><s:message code="word.admin"/></span>
            </c:when>

            <c:when test="${user.nrRoli == 2 }">
                <span style="color: black; "><s:message code="word.user"/></span>
            </c:when>

            <c:when test="${user.nrRoli == 3 }">
                <span style="color: black; "><s:message code="word.pricing"/></span>
            </c:when>

            <c:otherwise>
            <span style="color: black; "><s:message code="word.trader"/>
                        </c:otherwise>
                </c:choose>
        </td>
    </tr>

</table>

<table width="500" border="0" cellpadding="4" cellspacing="1" align="center">

    <tr>
        <td align="center">
            <input type="button" value="<s:message code="button.editProfile"/>"
                   onclick="window.location.href='${pageContext.request.contextPath}/editprofile'"
                   class="btn-two blue rounded"/>
        </td>
        <td align="center">
            <input type="button" value="<s:message code="button.changePassword"/>"
                   onclick="window.location.href='${pageContext.request.contextPath}/editpassword'"
                   class="btn-two blue rounded"/>
        </td>
    </tr>
</table>
</sf:form>
</body>
</html>