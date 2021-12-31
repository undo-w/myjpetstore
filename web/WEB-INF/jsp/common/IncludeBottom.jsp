<%--
  Created by IntelliJ IDEA.
  User: jinxiangyu
  Date: 2021/10/30
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>

<div id="Footer">

  <div id="PoweredBy">&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
  </div>

  <div id="Banner">
    <c:if test="${sessionScope.account.bannerOption==true}">
      ${sessionScope.account.bannerName}
    </c:if>
  </div>

</div>

</body>
</html>
