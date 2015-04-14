<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12" id="sidebar-wrapper">
<div id="sidebar"
	class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<ul>
		<li><strong>Kategorien</strong></li>
		<c:forEach items="${categoryList}" var="cats">
			<li><a href="cats_products?catID=${cats.getID2()}">
					${cats.getCategoryName()}</a></li>
		</c:forEach>
	</ul>
	</div>
	<div class="clear"></div>
	<p></p>
	<div id="sidebarlist" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<ul>
	<c:forEach items="${mostbought}" var="product">
	<li>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="sidebar-product-wrapper">
	<a href="productDetail?pID=${product.getID()}"><img src="resources/images/${product.getPicName()}"
				alt="pic" width="100px" height="100px"></a>

				<div id="home-productName">
					<a href="productDetail?pID=${product.getID()}">${product.getName()}</a>
				</div>
				<div id="btn-wrapper"
					class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div id="sidebar-to-basket-btn" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<a href="mainBasket">Add to <span
						class="glyphicon glyphicon-shopping-cart"></span></a>
						</div>
					<div class="price-btn">${product.getPrice()}&euro;</div>
				</div>
			</div>
			<div class="clear"></div>
				</li>
	</c:forEach>
	</ul>
</div>
</div>