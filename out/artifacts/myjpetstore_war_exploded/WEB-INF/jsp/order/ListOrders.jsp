<%--<%@ taglib prefix="stripes" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ include file="../common/IncludeTop.jsp"%>

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>
	<!-- 循环 -->
	<c:forEach var="order" items="${sessionScope.orderList}">
		<tr>
			<td><a href="myOrderToOrderServlet?orderId=${order.orderId}">
				${order.orderId}
			</td>
			<td><fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
			<td><fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../common/IncludeBottom.jsp"%>


