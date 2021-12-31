<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="Catalog">

	<form action="signOn">
		<p>Please enter your username and password.</p>
		<p>Username:<input type="text" name="username" value="" /> <br />
			Password:<input type="password" name="password" value="" /></p>
		<p>
			验证码：
			<input type="text" name="verificationCode" value="" />
			<img src="verfication" border="0" />
			<a href="kanbuqing">看不清，换一张</a>
		</p>
		<p><input type="submit" name="signon" value="Login" /></p>
		<c:if test="${sessionScope.account==null}">
			${sessionScope.msg}
		</c:if>
	</form>


	Need a user name and password? <a href="newAccountForm">Register Now!</a> </div>

<%@ include file="../common/IncludeBottom.jsp"%>

