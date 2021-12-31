<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="Catalog">
<%--	<form action="#">--%>

	<h3>User Information</h3>
<form action="updateAccount" method="post">
	<table>
		<tr>
			<td>User ID:</td>
			<td>${sessionScope.account.username}</td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="text" name="account.password"></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="text" name="repeatedPassword"></td>
		</tr>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>

		<input type="submit" value="Save Account Information">
	</form>

    <a href="viewListOrder">My Orders</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
