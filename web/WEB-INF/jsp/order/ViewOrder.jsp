<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<table>
		<tbody>
		<tr>
			<th align="center" colspan="2">${sessionScope.order.orderId}${sessionScope.order.orderDate}</th>
		</tr>
		<tr>
			<th colspan="2">Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>MasterCard</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td>999 9999 9999 9999 * Fake number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td>12/03</td>
		</tr>
		<tr>
			<th colspan="2">Billing Address</th>
		</tr>
		<tr>
			<td>First name:</td>
			<td>${sessionScope.account.firstName}</td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td>${sessionScope.account.lastName}</td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td>${sessionScope.account.address1}</td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td>${sessionScope.account.address2}</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>${sessionScope.account.city}</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>${sessionScope.account.state}</td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td>${sessionScope.account.zip}</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>${sessionScope.account.country}</td>
		</tr>
		<tr>
			<th colspan="2">Shipping Address</th>
		</tr>
		<tr>
			<td>First name:</td>
			<c:if test="${sessionScope.shipToFirstName!=null}">
				<td>${sessionScope.shipToFirstName}</td>
			</c:if>
			<c:if test="${sessionScope.shipToFirstName==null}">
				<td>${sessionScope.account.firstName}</td>
			</c:if>
		</tr>
		<tr>
			<td>Last name:</td>
			<c:if test="${sessionScope.shipToLastName!=null}">
				<td>${sessionScope.shipToLastName}</td>
			</c:if>
			<c:if test="${sessionScope.shipToLastName==null}">
				<td>${sessionScope.account.lastName}</td>
			</c:if>
		</tr>
		<tr>
			<td>Address 1:</td>
			<c:if test="${sessionScope.shipAddress1!=null}">
				<td>${sessionScope.shipAddress1}</td>
			</c:if>
			<c:if test="${sessionScope.shipAddress1==null}">
				<td>${sessionScope.account.address1}</td>
			</c:if>
		</tr>
		<tr>
			<td>Address 2:</td>
			<c:if test="${sessionScope.shipAddress2!=null}">
				<td>${sessionScope.shipAddress2}</td>
			</c:if>
			<c:if test="${sessionScope.shipAddress2==null}">
				<td>${sessionScope.account.address2}</td>
			</c:if>
		</tr>
		<tr>
			<td>City:</td>
			<c:if test="${sessionScope.shipCity!=null}">
				<td>${sessionScope.shipCity}</td>
			</c:if>
			<c:if test="${sessionScope.shipCity==null}">
				<td>${sessionScope.account.city}</td>
			</c:if>
		</tr>
		<tr>
			<td>State:</td>
			<c:if test="${sessionScope.shipState!=null}">
				<td>${sessionScope.shipState}</td>
			</c:if>
			<c:if test="${sessionScope.shipState==null}">
				<td>${sessionScope.account.state}</td>
			</c:if>
		</tr>
		<tr>
			<td>Zip:</td>
			<c:if test="${sessionScope.shipZip!=null}">
				<td>${sessionScope.shipZip}</td>
			</c:if>
			<c:if test="${sessionScope.shipZip==null}">
				<td>${sessionScope.account.zip}</td>
			</c:if>
		</tr>
		<tr>
			<td>Country:</td>
			<c:if test="${sessionScope.shipCountry!=null}">
				<td>${sessionScope.shipCountry}</td>
			</c:if>
			<c:if test="${sessionScope.shipCountry==null}">
				<td>${sessionScope.account.country}</td>
			</c:if>
		</tr>
		<tr>
			<td>Courier:</td>
			<td>UPS</td>
		</tr>

		<tr>
			<td colspan="2">Status: P</td>
		</tr>
		<tr>
			<td colspan="2">
				<table>
					<tbody>
					<tr>
						<th>Item ID</th>
						<th>Description</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Total Cost</th>
					</tr>

                 <c:forEach var="orderItem" items="${sessionScope.order.lineItems}">
					<tr>
						<td>
							<a href="viewItem?itemId=${orderItem.item.itemId}">
							${orderItem.item.itemId}
						</a>
						</td>

						<td>${orderItem.item.attribute1} ${orderItem.item.attribute2}
								${orderItem.item.attribute3} ${orderItem.item.attribute4}
								${orderItem.item.attribute5} ${orderItem.item.product.name}
						</td>

						<td>${orderItem.quantity}</td>
						<td><fmt:formatNumber value="${orderItem.item.listPrice}"
											  pattern="$#,##0.00" /></td>
						<td><fmt:formatNumber value="${orderItem.total}"
											  pattern="$#,##0.00" /></td>
					</tr>
				 </c:forEach>
					<tr>
						<th colspan="5">Sub Total:
							<fmt:formatNumber
									value="${sessionScope.order.totalPrice}" pattern="$#,##0.00" /></th>
					</tr>
					</tbody>
				</table>
			</td>
		</tr>

		</tbody>
	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
