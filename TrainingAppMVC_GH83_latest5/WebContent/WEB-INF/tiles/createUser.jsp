<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
		<h3>Create user</h3>
		
		<form action="${pageContext.request.contextPath}/doCreateUser" method="post">
			<table class="formTable">
				<tr><td>Name of User</td><td><input name="userName" type="text"> </td></tr>
				<tr><td>Users Email</td><td><input name="userEmail" type="text"> </td></tr>
				<tr><td>Password</td><td><input name="password" type="text"> </td></tr>
				
				<tr><td><input type="submit" value="Save User"> </td></tr>
			</table>
		</form>
		
		<p><a href="${pageContext.request.contextPath}/adminPage">Go back</a></p>		