<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Webshop 0.3</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="resources/bootstrap/css/style.css" rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#login-trigger').click(function() {
			$(this).next('#login-content').slideToggle();
			$(this).toggleClass('active');

			if ($(this).hasClass('active'))
				$(this).find('span')
			else
				$(this).find('span')
		})
	});
</script>
</head>
<body>

<div id="wrapper" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

	<div id="header-wrapper"
		class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<jsp:include page="header.jsp"></jsp:include>

		<c:choose>
			<c:when test="${page == 'home' }">

				<div id="slider-wrapper"
					class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="col-lg-2 col-md-2 col-sm-1 normal_height"></div>
					<jsp:include page="slider.jsp"></jsp:include>
				</div>
			</c:when>
		</c:choose>
	</div>
	<div id="container" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="col-lg-2 col-md-2 col-sm-1 normal_height"></div>
		<div id="content-wrapper"
			class="col-lg-8 col-md-8 col-sm-10 col-xs-12">
			<c:choose>
				<c:when test="${page == 'categories'}">
				</c:when>
				<c:otherwise>
					<jsp:include page="sidebar.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page == 'home' }">
					<jsp:include page="home.jsp"></jsp:include>
				</c:when>
				<c:when test="${page == 'products' }">
					<jsp:include page="products.jsp"></jsp:include>
				</c:when>
				<c:when test="${page == 'categories' }">
					<jsp:include page="categories.jsp"></jsp:include>
				</c:when>
				<c:when test="${page == 'cats_products' }">
					<div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
					<jsp:include page="cats_products.jsp"></jsp:include>
					</div>
				</c:when>
				<c:when test="${page == 'login' }">
					<jsp:include page="login.jsp"></jsp:include>
				</c:when>
				<c:when test="${page == 'productDetail'}">
					<jsp:include page="productDetail.jsp"></jsp:include>
				</c:when>
			</c:choose>
			<jsp:include page="basket.jsp"></jsp:include>


		</div>

		<div class="col-lg-2 col-md-2 col-sm-1"></div>
	</div>
	
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
		<div class="col-lg-2 col-md-2 col-sm-1"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>