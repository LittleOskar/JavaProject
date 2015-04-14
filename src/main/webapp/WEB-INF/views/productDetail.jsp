<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script>
	$(document)
		.ready(function(){$("button").click(function(){
			$("#relatives").load("cats_products?catID=${product.getCatID()}&detailPage=true");
		});
	});
</script>

<div class="col-lg-7 col-md-7 col-sm-9 col-xs-12" id="productDetail">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
		id="breadcrumb-wrapper">
		<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12" id="breadcrumb">
			Startseite / Kategorien / Brillen / ${product.getName()}</div>
	</div>

	<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12"
		id="productDetail-wrapper">
		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"
			id="image-collection">
			<img src="resources/images/${product.getPicName()}">
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${user.getAdmin() == 1}"> --%>
<%-- 			<form:form modelAttribute="editedProduct" action="editProduct"> --%>
<!-- 			<br> -->
<!-- 			Bild ändern: -->
<%-- 			<form:input placeholder="${product.getPicName()}" path="picURL"/> --%>
<!-- 			<input type="submit" value="Submit">    -->
<%-- 			</form:form> --%>
<%-- 			</c:when> --%>
<%-- 			</c:choose> --%>
		</div>
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12" id="info-wrapper">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
				id="productDetail-text">
				<p></p>
				<h2>${product.getName()}</h2>
				<hr>
				<div class="col-lg-6 col-md-6 col-sm-8 col-xs-12"
					id="detailPage-price">${product.getPrice()}&euro;</div>
				<!-- 				hier submit-form einbauen -->
				<select id="detailPage-amount" size="1" name="amount">
					<c:forEach var="i" begin="1" end="${product.getAmount()}">
						<option><c:out value="${i}" /></option>
					</c:forEach>
				</select>

				<div id="detailPage-to-basket"
					class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<a href="mainBasket">Add to <span
						class="glyphicon glyphicon-shopping-cart"></span></a>
				</div>
				<div class="clear"></div>
				<hr>
				<c:choose>
					<c:when test="${product.getAmount() <= 20}">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							id="detailPage-little-amount">
							<strong>Nur noch ${product.getAmount()} Artikel
								verfügbar!</strong>
						</div>
					</c:when>
					<c:otherwise>
						<strong>Artikel verfügbar</strong>
					</c:otherwise>
				</c:choose>
				<hr>
				<p></p>
			</div>
		</div>
	</div>
	<div class="clear"></div>

	<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12" id="tab-wrapper">
		<ul class="nav nav-tabs tab-bar">
			<li class="active" id="div2"><a class="tab-links" href="#details" data-toggle="tab">Details</a>
			</li>
			<li><a class="tab-links" href="#relatives" data-toggle="tab"><button id="btn-relatives">Related Products</button></a></li>
		</ul>
	</div>
	<div class="clear"></div>
	<div class="tab-content">
		<div class="tab-pane fade active in" id="details">
			${product.getDescription()}</div>
		<div class="tab-pane fade" id="relatives">
		</div>
	</div>
	<div class="clear"></div>
</div>