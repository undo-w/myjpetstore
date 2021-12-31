<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="Catalog">

    <form action="signOn">
        <p>Please enter your username and password.</p>
        <p>Username:<input type="text" name="username" value="" /> <br />
            Password:<input type="password" name="password" value="" /></p>
        验证码：
        <input type="text" name="verificationCode" value="" />
        <img src="verfication" border="0" />
        <p><input type="submit" name="signon" value="Login" /></p>
        ${sessionScope.msg}
    </form>


    Need a user name and password? <a href="#">Register Now!</a> </div>

<%@ include file="../common/IncludeBottom.jsp"%>

