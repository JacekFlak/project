<table width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg">
	<tr>
		<td align="left" width="900">
			<a href="/"> <img src="/resources/images/home.png" width="19" height="19"/></a>&nbsp;&nbsp;

			 <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="/newrequest"><s:message code="menu.newRequest"/></a>&nbsp;&nbsp;
             </sec:authorize>

                <sec:authorize access="hasRole('ROLE_TRADER')">
                    <a href="/newproduct"><s:message code="menu.newProduct"/></a>&nbsp;&nbsp;
                    <a href="/newstore"><s:message code="menu.newStore"/></a>&nbsp;&nbsp;
                </sec:authorize>
		</td>

		<td align="right">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
        				<a href="/admin"><s:message code="menu.adminPage"/></a>&nbsp;&nbsp;
                        <a href="/register"><s:message code="menu.register"/></a>&nbsp;&nbsp;
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_TRADER')">
                    <a href="/trader"><s:message code="menu.trader"/></a>&nbsp;&nbsp;
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="/user"><s:message code="menu.user"/></a>&nbsp;&nbsp;
                </sec:authorize>

        <sec:authorize access="hasRole('ROLE_PRICING')">
                            <a href="/user"><s:message code="menu.user"/></a>&nbsp;&nbsp;
                        </sec:authorize>

		<sec:authorize access="hasRole('ANONYMOUS')">
			<a href="/login"><s:message code="menu.login"/></a>&nbsp;&nbsp;
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<a href="/profile"><img src="/resources/images/profile.jpg" width="20" height="20"  title="<s:message code="menu.profile"/>"/>&nbsp;&nbsp;
			<a href="/contact"><img src="/resources/images/help.png" width="20" height="20"  title="<s:message code="menu.support"/>"/> &nbsp;&nbsp;
			<a href="/logout"> <img src="/resources/images/logout.png" width="20" height="20"  title="<s:message code="menu.logout"/>"/></a>&nbsp;&nbsp;
		</sec:authorize>
		</td>
	</tr>
</table>