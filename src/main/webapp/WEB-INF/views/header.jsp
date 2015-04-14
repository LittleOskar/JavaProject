<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="header_wrapper" class="col-lg-12">
	<div class="col-lg-2 col-md-2 col-sm-1 col-xs-0"></div>
	<div id="header_container"
		class="col-lg-8 col-md-8 col-sm-10 col-xs-12">
		<div id="welcome-line" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

			<c:choose>
				<c:when test="${user.getUserID() > 0 && not empty user.getUserID()}">
					<div id="welcome-text" class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
						Hallo ${user.getFirstname()}!</div>

					<div id="logout-line" class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
						<div id="formular_logout">
							<a id="logout_btn" href="login">Logout</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div id="welcome-text" class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
					&nbsp;
						<div id="logout-line" class="col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<div id="header" class="nav col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<nav>
				<ul>
					<li>
					<a id="logo-text" href="home">
					<img alt="logo" src="resources/images/glasses-logo.svg"
						width="150px" height="40px">
						Glasses</a></li>
					<li><form action='blob' method='GET' id="formular_suchen">
							<input id="searchfield" name='searchParam'
								placeholder="Suchbegriff..." type='text' autocomplete="off" />
							<input id="search_btn" type="submit" value='Suchen' />
						</form></li>
					<li><a href="home">Startseite</a></li>
					<li><a href="products">Produkte</a></li>
					<li><a href="categories">Kategorien</a></li>
					
					<c:choose>
					<c:when test="${user.getUserID() > 0 && not empty user.getUserID()}"></c:when>
					<c:otherwise>
					<li id="login">
						<!-- 					<a id="login-trigger" href="#"> Log in <span --> <!-- 							class="glyphicon glyphicon-chevron-down"></span> -->
						<!-- 					</a> --> <!-- 						<div id="login-content"> --> <%-- 							<form:form action="home" commandName="index" method="POST" > --%>
						<!-- 								<fieldset id="inputs"> --> <%-- 									<form:input path="email" placeholder="Your email address" required /> --%>
						<%-- 									<form:password path="password" placeholder="Password" required /> --%>
						<!-- 								</fieldset> --> <!-- 								<fieldset id="actions"> -->
						<!-- 									<input type="submit" id="submit" value="Log in"> -->
						<!-- 								</fieldset> --> <%-- 							</form:form> --%> <!-- 						</div> -->
						<a href="login">Login</a>

					</li>
					</c:otherwise>
					</c:choose>
					


					<!-- 				<form> -->
					<!-- 				<input id="login-btn" type="submit" value="Login" /> -->
					<!-- 				</form> -->

				</ul>
			</nav>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-1 col-xs-0"></div>
</div>