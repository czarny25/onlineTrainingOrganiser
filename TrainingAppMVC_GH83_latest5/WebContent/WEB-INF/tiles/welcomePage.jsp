<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
	
	
	
	<div class="welcomePage">		
		<div class="top">
			<h1>Welcome in training database</h1>
			<br>		
			<h1>First time in?</h1>	 		 			
		</div>		
		<div class="bottom">
			<a href="<c:url value='/guestPage'/>">Take free tour</a>
			<br>
			<br>
			<sec:authorize access="!isAuthenticated()">		
				<a href="<c:url value='/createNewAccount'/>">Register now and create your own training</a><br><br>		
			</sec:authorize>			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<c:url value='/adminPage'/>">Administrators section</a>	
			</sec:authorize>
		</div>
	</div>