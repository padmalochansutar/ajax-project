<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

	
<body>

	<div>

		<form>
			<div>
				<label>COUNTRY NAME:</label>
				<select onchange="country_state()" id="countryId">
					<option value="0">-select-</option>
					<c:forEach items="${countryList }" var="country">
						<option value="${country.countryId }">${country.name }</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label>STATES NAME:</label>
				 <select onchange="state_city()" id="stateId">
					<option value="0">-select-</option>
					<%-- <c:forEach items="${statesList }" var="states">
						<option value="${states.stateId }">${states.name }</option>
					</c:forEach> --%>
				</select>
			</div>

			<div>
				<label>CITIES NAME:</label> 
				<select id="cityId">
					<option value="0">-select-</option>
					<%-- <c:forEach items="${citiesList }" var="cities">
						<option value="${cities.cityId }">${cities.name }</option>
					</c:forEach> --%>
				</select>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	function country_state() {
		var country=$("#countryId").val();
		alert(country);
		$.ajax({
			type : "GET",
			url : "./getStatesByCountryId",
			data : "countryId=" + country,
			
			success : function(response) {
				$("#stateId").html(response)
			}

		});
	}

	function state_city() {
		
		var state =$("#stateId").val();
		alert(state);
		$.ajax({
			type : "GET",
			url : "./getCitiesByStateId",
			data : "stateId=" + state,
			success : function(response) {
				$("#cityId").html(response);
			}

		});
	}
</script>
</html>