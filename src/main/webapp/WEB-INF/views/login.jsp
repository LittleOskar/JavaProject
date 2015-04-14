<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="login-page" class="col-lg-7 col-md-7 col-sm-9 col-xs-12 ">
<strong>Login:</strong>
<p></p>
<form:form modelAttribute="inputUser" action="login">  
        <form:input placeholder="E-Mail" path="email"></form:input>
        <form:password placeholder="Password" path="password"></form:password>
            <input type="submit" value="Login">   
</form:form>
</div>