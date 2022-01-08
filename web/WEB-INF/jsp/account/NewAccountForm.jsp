<%@ include file="../common/IncludeTop.jsp"%>

<link href="${pageContext.request.contextPath}/CSS/NewAccountForm.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/UsernameExist.js"></script>
<div id="Catalog">
	<form action="newAccount">
	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td>
				<input id="username" type="text" name="username" onblur="checkUsername();">
				<span id="usernameTips"></span>
			</td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="text" name="repeatedPassword"></td>
		</tr>
	</table>

	<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" value="Save Account Information">

	</form>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>