<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="sidebar" class="col-lg-2 col-md-2 col-sm-3 col-xs-12 normal_height">
</div>
<div id="categories" class="col-lg-7 col-md-7 col-sm-9 col-xs-12 ">
<ul>
<li><strong>Kategorien</strong></li>
<c:forEach items="${cats}" var="cat">
<li>
<a href="cats_products?catID=${cat.getID2()}">
${cat.getCategoryName()}
</a>
</li>
</c:forEach>
</ul>
</div>