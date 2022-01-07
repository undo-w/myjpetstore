<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><input type="text" name="account.firstName" value="${sessionScope.account.firstName}"></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" name="account.lastName" value="${sessionScope.account.lastName}"></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="account.email" value="${sessionScope.account.email}"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input type="text" name="account.phone" value="${sessionScope.account.phone}"></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input type="text" size="40" name="account.address1" value="${sessionScope.account.address1}"></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" size="40" name="account.address2" value="${sessionScope.account.address2}"></td>
	</tr>

	<tr>
		<td>City:</td>
		<td><input type="text" name="account.city" value="${sessionScope.account.city}"></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" size="4" name="account.state" value="${sessionScope.account.state}"></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" size="10" name="account.zip" value="${sessionScope.account.zip}"></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" size="15" name="account.country" value="${sessionScope.account.country}"></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
			<select name="account.languagePreference" value="${sessionScope.account.languagePreference}">
				<c:if test="${sessionScope.account!=null}">
					<option>${sessionScope.account.languagePreference}</option>
				</c:if>
				<c:if test="${sessionScope.account==null}">
					<option value="English" selected="selected">English</option>
					<option value="Japanese">Japanese</option>
					<option value="Chinese">Chinese</option>
				</c:if>
			</select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
		<select name="account.favouriteCategoryId" value="${sessionScope.account.favouriteCategoryId}">
			<option value="FISH">FISH</option>
			<option value="DOGS">DOGS</option>
			<option value="REPTILES">REPTILES</option>
			<option value="CATS">CATS</option>
			<option value="BIRDS">BIRDS</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td>
			<c:if test="${sessionScope.account.listOption==true}">
				<input type="checkbox" name="account.listOption" checked="checked" value="${sessionScope.account.listOption}"/>
			</c:if>
			<c:if test="${sessionScope.account.listOption==false}">
				<input type="checkbox" name="account.listOption"  value="${sessionScope.account.listOption}"/>
			</c:if>
			<c:if test="${sessionScope.account==null}">
				<input type="checkbox" name="account.listOption"  value="${sessionScope.account.listOption}"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td>
		<c:if test="${sessionScope.account.bannerOption==true}">
			<input type="checkbox" name="account.bannerOption" checked="checked" value="${sessionScope.account.bannerOption}"/>
		</c:if>
		<c:if test="${sessionScope.account.bannerOption==false}">
			<input type="checkbox" name="account.bannerOption"  value="${sessionScope.account.bannerOption}"/>
		</c:if>
		<c:if test="${sessionScope.account==null}">
				<input type="checkbox" name="account.bannerOption"  value="${sessionScope.account.bannerOption}"/>
		</c:if>
		</td>
	</tr>

</table>
