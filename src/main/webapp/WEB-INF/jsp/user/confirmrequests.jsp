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

<h2><s:message code="menu.user"/></h2>
<%@include file="/WEB-INF/incl/usermenu.app" %>

<h2><s:message code="menu.requests"/></h2>

<c:set var="count" value="${recordStartCounter }"/>
<div align="center">
    <div align="right" style="width: 1000px; padding: 2px;">
        <input type="hidden" name="cp" id="cp" value="${currentPage}"/>&nbsp;&nbsp;
        <input type="text" id="searchString"/>&nbsp;&nbsp;
        <input type="button" value="<s:message code="button.search"/>" onclick="startSearch(0);"/><br/>
        <span id="errorSearch" style="color: red;"></span>
    </div>

    <table width="1000" border="1" cellpadding="6" cellspacing="2" bgcolor="white">
        <tr bgcolor="#70a5ff">
            <td width="10" align="center"></td>
            <td width="30" align="center"><b><s:message code="request.id"/></b></td>
            <td width="50" align="center"><b><s:message code="request.quantity"/></b></td>
            <td width="80" align="center"><b><s:message code="store.name"/></b></td>
            <td width="50" align="center"><b><s:message code="product.name"/></b></td>
            <td width="350" align="center"><b><s:message code="request.description"/></b></td>
            <td width="100" align="center"><b><s:message code="request.decision"/></b></td>
        </tr>
        <c:forEach var="r" items="${requestList }" varStatus="status">
            <c:set var="count" value="${count+1}"/>
            <tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
                <c:choose>
                    <c:when test="${r.approved == 1 }">
                        <td align="center"><c:out value="${count }"/></td>
                        <td align="center"><c:out value="${r.id }"/></td>
                        <td align="center"><c:out value="${r.quantity }"/></td>
                        <td align="center"><c:out value="${storeList[status.index].name}"/></td>
                        <td align="center"><c:out value="${productList[status.index].name}"/></td>
                        <td align="left"><c:out value="${r.description }"/></td>
                        <td align="center">
                            <a href="">
                                <img src="/resources/images/approve.png" width="55" height="35"
                                     title="<s:message code="request.approve"/>"/> </a>
                            <a href="">
                                <img src="/resources/images/reject.png" width="55" height="35"
                                     title="<s:message code="request.reject"/>"/> </a>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
    </table>

    <table width="1000" border="0" cellpadding="6" cellspacing="2" bgcolor="#70a5ff">
        <tr>
            <td width="300" align="left">
                <s:message code="info.page"/> ${currentPage} <s:message code="info.from"/> ${totalPages}
            </td>
            <td align="right">

                <c:if test="${currentPage > 1}">
                    <input type="button"
                           onclick="window.location.href='${pageContext.request.contextPath}/user/confirmrequests/${currentPage - 1}'"
                           value="<s:message code="link.previous"/>"/>&nbsp;&nbsp;
                </c:if>

                <c:if test="${currentPage < totalPages}">
                    <input type="button"
                           onclick="window.location.href='${pageContext.request.contextPath}/user/confirmrequests/${currentPage + 1}'"
                           value="<s:message code="link.next"/>"/>
                </c:if>

            </td>
        </tr>
    </table>
</div>

</body>
</html>