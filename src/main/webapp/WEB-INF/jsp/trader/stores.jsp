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
    <title><s:message code="menu.Stores"/></title>
    <script type="text/javascript">
        function changeTrBg(row) {
            row.style.backgroundColor = "#e6e6e6";
        }

        function defaultTrBg(row) {
            row.style.backgroundColor = "white";
        }
    </script>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="menu.trader"/></h2>
<%@include file="/WEB-INF/incl/trmenu.app" %>

<h2><s:message code="menu.Stores"/></h2>

<c:set var="count" value="${recordStartCounter }"/>
<div align="center">
    <div align="right" style="width: 1000px; padding: 2px;">
        <input type="hidden" name="cp" id="cp" value="${currentPage}"/>
    </div>
    <table width="1000" border="0" cellpadding="6" cellspacing="2">
        <tr bgcolor="#70a5ff">
            <td width="40" align="center"></td>
            <td width="190" align="center"><b><s:message code="store.name"/></b></td>
            <td width="190" align="center"><b><s:message code="store.city"/></b></td>
            <td width="200" align="center"><b><s:message code="store.street"/></b></td>
            <td width="100" align="center"><b><s:message code="store.number"/></b></td>
            <td width="100" align="center"><b><s:message code="store.country"/></b></td>
            <td width="100" align="center"><b><s:message code="store.email"/></b></td>
            <td width="100" align="center"><b><s:message code="store.phone"/></b></td>
            <td width="50"></td>
        </tr>
        <c:forEach var="s" items="${storeList }">
            <c:set var="count" value="${count+1}"/>
            <tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
                <td align="center"><c:out value="${count }"/></td>
                <td align="center"><c:out value="${s.name }"/></td>
                <td align="center"><c:out value="${s.city }"/></td>
                <td align="center"><c:out value="${s.street }"/></td>
                <td align="center"><c:out value="${s.number }"/></td>
                <td align="center"><c:out value="${s.country }"/></td>
                <td align="center"><c:out value="${s.email }"/></td>
                <td align="center"><c:out value="${s.phone }"/></td>
            </tr>
        </c:forEach>
    </table>
    <table width="1000" border="0" cellpadding="6" cellspacing="0" bgcolor="#70a5ff">
        <tr>
            <td width="300" align="left">
                <s:message code="info.page"/> ${currentPage} <s:message code="info.from"/> ${totalPages}
            </td>
            <td align="right">

                <c:if test="${currentPage > 1}">
                    <input type="button"
                           onclick="window.location.href='${pageContext.request.contextPath}/trader/stores/${currentPage - 1}'"
                           value="<s:message code="link.previous"/>"/>&nbsp;&nbsp;
                </c:if>

                <c:if test="${currentPage < totalPages}">
                    <input type="button"
                           onclick="window.location.href='${pageContext.request.contextPath}/trader/stores/${currentPage + 1}'"
                           value="<s:message code="link.next"/>"/>
                </c:if>

            </td>
        </tr>
    </table>
</div>
</body>
</html>