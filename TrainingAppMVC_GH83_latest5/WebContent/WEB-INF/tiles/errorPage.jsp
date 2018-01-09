<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script type="text/javascript"> 

		function reload() {
			window.parent.location = window.parent.location.href;			
		}

</script>


<div class="container" >
 	<div class="row">
		<div class="errorPage">
		 	<div class="aboutText">
		 		<h1>Sorry something went wrong</h1>
		 	</div>
		 	<div class="aboutButton">	
				<button class="btn" 
					onclick="reload()">Reload
				</button>						 		
		 	</div>
		</div>
 	</div>
</div>











