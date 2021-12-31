<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="confirmOrder" method="post">
	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select name="cardType">
					<option selected="selected" value="Visa">Visa</option>
					<option value="MasterCard">MasterCard</option>
					<option value="American Express">American Express</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td>
				<input type="text" name="creditCard" value="999 9999 9999 9999"/>
				
			</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input type="text" name="expiryDate" value="12/03"/></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="billToFirstName" value="${sessionScope.account.firstName}"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="billToLastName" value="${sessionScope.account.lastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" name="billAddress1" value="${sessionScope.account.address1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" name="billAddress2" value="${sessionScope.account.address2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="billCity" value="${sessionScope.account.city}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="billState" value="${sessionScope.account.state}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" name="billZip" value="${sessionScope.account.zip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" name="billCountry" value="${sessionScope.account.country}"/></td>
		</tr>

		<tr>
			<td colspan="2"><input name="shippingAddressRequired" type="checkbox" value="off">
				Ship to different address...
			</td>
		</tr>
	</table>

		<input name="newOrder" value="Continue" type="submit"/>
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>