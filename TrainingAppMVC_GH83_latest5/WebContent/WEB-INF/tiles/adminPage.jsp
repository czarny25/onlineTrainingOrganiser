<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	
<div class="homePage container-fluid " >			
			<div class="row">			
				<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
					
					<h2 >For administrator only</h2>		
					
					
					<ul class="listItems list-group">
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/showUsers">View all users</a>
					  </li>
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/createUser">Create new user</a>
					  </li>
					  <li class="list-group-item">
					  	<a href="${pageContext.request.contextPath}/homePage">Go back to home page</a>
					  </li>	  
					</ul>
				</div>
			</div>
			
		</div>	
	
	
	
	