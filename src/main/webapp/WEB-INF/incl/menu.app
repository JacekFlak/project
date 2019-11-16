<table width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#e6f2ff">
	<tr>
		<td align="left" width="900">
			<a href="/"><s:message code="menu.mainPage"/></a>&nbsp;&nbsp;

			 <sec:authorize access="isAuthenticated()">
                    <a href="/requests"><s:message code="menu.requests"/></a>&nbsp;&nbsp;
                    <a href="/newrequest"><s:message code="menu.newRequest"/></a>&nbsp;&nbsp;
                    <a href="/newproduct"><s:message code="menu.newProduct"/></a>&nbsp;&nbsp;
              </sec:authorize>

		</td>

		<td align="right">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
        				<a href="/admin"><s:message code="menu.adminPage"/></a>&nbsp;&nbsp;

        </sec:authorize>

		<sec:authorize access="hasRole('ANONYMOUS')">
			<a href="/login"><s:message code="menu.login"/></a>&nbsp;&nbsp;
			<a href="/register"><s:message code="menu.register"/></a>&nbsp;&nbsp;
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<a href="/profile"><s:message code="menu.profile"/></a>&nbsp;&nbsp;
			<a href="/logout"><s:message code="menu.logout"/></a>&nbsp;&nbsp;
		</sec:authorize>
		</td>

	</tr>
</table>