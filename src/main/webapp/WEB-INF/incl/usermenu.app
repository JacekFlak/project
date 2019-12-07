<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_PRICING')">
	<table width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg">
		<tr>
			<td align="left">
			<sec:authorize access="hasRole('ROLE_USER')">
				<a href="/user/requests/1"><s:message code="menu.Requests"/></a>&nbsp;&nbsp;
			 </sec:authorize>

			 <sec:authorize access="hasRole('ROLE_PRICING')">
             				<a href="/user/confirmrequests/1"><s:message code="menu.Requests"/></a>&nbsp;&nbsp;
             </sec:authorize>

			</td>
		</tr>
	</table>
</sec:authorize>