<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
    
 <div class="aboutPageHead container-fluid" >
 	<div class="row">
		<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
		 	<div class="aboutText">
		 		<h1>About Training App</h1>
		 		<p>
					The Online Training Organizer is a mobile software that helps people to build detailed, advanced and highly customised personal training plan for bodybuilding and fitnes training. that can be accessable in a quick way during training.  
				</p>
		 	</div>
		</div>
 	</div>
</div>
<div class="aboutPage container-fluid" >
 	<div class="row">
	 	<div class="aboutFeatures col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
		  <h1 class="featuresTitle" >Features</h1>	   
		  <ul class="featuresList ">
		    <li class="aboutlistItem list-group-item">Quick access to your current training plan on any mobile device</li>
		    <li class="aboutlistItem list-group-item">Ability to create highly customized training plan up to personal preferences on mobile and desktop</li>
		    <li class="aboutlistItem list-group-item">Add your own exercises to your training or use one of existing</li>
		 	<li class="aboutlistItem list-group-item">Use one of many ready to use training plans</li>
		  </ul>
		</div>
		<sec:authorize access="!isAuthenticated()">	
		 	<div class="registerHere col-xs-offset-0 col-xs-12">	
				<a href="<c:url value='/createNewAccount'/>">Register now</a><br><br>	
			</div>	
		</sec:authorize>
 	</div>
 </div>