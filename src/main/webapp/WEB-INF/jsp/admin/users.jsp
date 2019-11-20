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
    <title><s:message code="menu.users"/></title>
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

<h2><s:message code="menu.users"/></h2>

<c:set var="count" value="${recordStartCounter }"/>
<div align="center">
    <div align="right" style="width: 1000px; padding: 2px;">
        <input type="hidden" name="cp" id="cp" value="${currentPage}"/>
    </div>
    <table width="1000" border="0" cellpadding="6" cellspacing="2">
        <tr bgcolor="#70a5ff">
            <td width="40" align="center"></td>
            <td width="40" align="center"><b><s:message code="admin.user.id"/></b></td>
            <td width="190" align="center"><b><s:message code="register.name"/></b></td>
            <td width="190" align="center"><b><s:message code="register.lastName"/></b></td>
            <td width="200" align="center"><b><s:message code="register.email"/></b></td>
            <td width="100" align="center"><b><s:message code="profile.role"/></b></td>
            <td width="190" align="center"><b><s:message code="profile.isActive"/></b></td>
            <td width="50"></td>
        </tr>
        <c:forEach var="u" items="${userList }">
            <c:set var="count" value="${count+1}"/>
            <tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
                <td align="right"><c:out value="${count }"/></td>
                <td align="right"><a href="edit/${u.id }"><c:out value="${u.id }"/></a></td>
                <td align="left"><a href="edit/${u.id }"><c:out value="${u.name }"/></a></td>
                <td align="left"><a href="edit/${u.id }"><c:out value="${u.lastName }"/></a></td>
                <td align="center"><a href="edit/${u.id }"><c:out value="${u.email }"/></a></td>

                <td align="center">
                    <c:choose>

                    <c:when test="${u.nrRoli == 1 }">
                        <span style="color: blue; "><s:message code="word.admin"/></span>
                    </c:when>

                    <c:when test="${u.nrRoli == 2 }">
                        <span style="color: black; "><s:message code="word.user"/></span>
                    </c:when>

                    <c:when test="${u.nrRoli == 3 }">
                        <span style="color: black; "><s:message code="word.pricing"/></span>
                    </c:when>

                    <c:otherwise>
                    <span style="color: black; "><s:message code="word.trader"/>
                        </c:otherwise>

                    </c:choose>
                </td>

                <td align="center">
                    <c:choose>
                        <c:when test="${u.active == 1 }">
                            <span style="color: green; "><s:message code="word.yes"/></span>
                        </c:when>
                        <c:otherwise>
                            <span style="color: red; "><s:message code="word.no"/></span>
                        </c:otherwise>
                    </c:choose>
                </td>
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
                           onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPage - 1}'"
                           value="<s:message code="link.previous"/>"/>&nbsp;&nbsp;
                </c:if>

                <c:if test="${currentPage < totalPages}">
                    <input type="button"
                           onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPage + 1}'"
                           value="<s:message code="link.next"/>"/>
                </c:if>

            </td>
        </tr>
    </table>
</div>
</body>
</html>