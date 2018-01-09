<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">

	function onReady() {	
		var millisecondsToWait = 1000;
		setTimeout(function() {
			window.location.href = "/trainings/showUsersTrainings";
		}, millisecondsToWait);		
	}
	$(document).ready(onReady);
	
</script>

<div class="accessDenied container-fluid" >
 	<div class="row">
		<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
		 	<div class="aboutText">
		 		<h1>Training Deleted</h1>		 			 		
		 	</div>
		</div>
 	</div>
</div>

