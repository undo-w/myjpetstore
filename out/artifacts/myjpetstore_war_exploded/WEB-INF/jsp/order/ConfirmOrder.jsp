<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">
	Please confirm the information below and then press continue...

	<table>
		<tbody>
		<tr>
			<th align="center" colspan="2">Order
			</th>
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

		</tbody>
	</table>

	<a class="Button" href="viewOrder">Confirm</a>
</div>


<%@ include file="../common/IncludeBottom.jsp"%>





