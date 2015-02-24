<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
	<tr>
		<td colspan="10" align="right">
			<span style="font:16px/22px Georgia, serif; color:#786e4e; height:37px;">Hello, <s:property value="#session.username" /></span>
		</td>
	</tr>
	<tr>
        <s:if test="#session.countries=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageCountries.action">Countries</s:a>
            </td>
        </s:if>
        <s:if test="#session.citystate=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageCitiesStates.action">Cities</s:a>
            </td>
        </s:if>
        <s:if test="#session.authors=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageAuthors.action">Authors</s:a>
            </td>
        </s:if>
        <s:if test="#session.publishers=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManagePublishers.action">Publishers</s:a>
            </td>
        </s:if>
        <s:if test="#session.categories=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageCategories.action">Categories</s:a>
            </td>
        </s:if>
        <s:if test="#session.users=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageUsers.action">Users</s:a>
            </td>
        </s:if>
        <s:if test="#session.books=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageBooks.action">Books</s:a>
            </td>
        </s:if>
        <s:if test="#session.customers=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageCustomers.action">Customers</s:a>
            </td>
        </s:if>
        <s:if test="#session.transactions=='true'">
            <td align="center" class="menuborder" width="10%">
                <s:a href="showManageTransactions.action">Transactions</s:a>
            </td>
        </s:if>
        <td align="center" class="menuborder" width="10%">
			<a href="<s:url action="doLogout" />">Logout</a>
		</td>
	</tr>
</table>