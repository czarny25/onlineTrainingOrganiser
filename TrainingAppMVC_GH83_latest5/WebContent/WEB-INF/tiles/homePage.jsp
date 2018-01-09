<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		
		
		<div class="homePage container-fluid " >			
			<div class="row">			
				<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
					<h2 >Welcome Marcin </h2>
					<h2 >Choose one from bellows options</h2>		
					
					
					<ul class="listItems list-group">
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/showTodaysTraining">Go to your todays training</a>
					  </li>
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/showUsersTrainings">View all your Training's</a>
					  </li>
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/showAllTrainings">View all Training's titles</a>
					  </li>
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/createTraining">Create new Training</a>
					  </li>	
				  <sec:authorize access="hasRole('ROLE_ADMIN')">
					  <li class="list-group-item">
						 <a href="<c:url value='/adminPage'/>">Administration Page</a>
					  </li>
				  </sec:authorize>				  
					</ul>
				</div>
			</div>
			
		</div>	







