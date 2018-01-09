<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>





<div class="homePage container">
	<div class="row">
		<div class="noTrainToday col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
			
			<h2>Sorry you have no training for today</h2>

			<p />
			<br>
			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value='/createTraining'/>">Create new Training</a>
			</sec:authorize>

			<p />

			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value='/homePage'/>">Go back to home page</a>
			</sec:authorize>


		</div>


	</div>
</div>






