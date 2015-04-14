<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="products-list" class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
	<ul>
		<c:forEach items="${products}" var="product">
			<li><a href="productDetail?pID=${product.getID()}"><img
					src="resources/images/${product.getPicName()}" alt="pic"
					width="180px" height="180px"></a>

				<div id="home-productName">
					<a href="productDetail?pID=${product.getID()}">${product.getName()}</a>
				</div>
				<div id="btn-wrapper"
					class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

					<c:choose>
						<c:when test="${user.getAdmin() == 1}">
						<div
								class="instant-to-basket col-lg-5 col-md-5 col-sm-5 col-xs-5">
								<a href="#">Remove</a>
							</div>
						</c:when>
						<c:otherwise>
							<div
								class="instant-to-basket col-lg-5 col-md-5 col-sm-5 col-xs-5">
								<a href="mainBasket">Add to <span
									class="glyphicon glyphicon-shopping-cart"></span></a>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 price-btn">${product.getPrice()}&euro;</div>
				</div></li>

		</c:forEach>
	</ul>
</div>