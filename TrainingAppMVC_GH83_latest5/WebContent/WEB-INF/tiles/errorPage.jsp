<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script type="text/javascript"> 

		function reload() {
			window.parent.location = window.parent.location.href;
			
		}

</script>




<div class="accessDenied container-fluid" >
 	<div class="row">
		<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
		 	<div class="aboutText">
		 		<h1>Sorry something went wrong</h1>
		 		<sec:authorize access="isAuthenticated()">
					<button class="btn" 
						onclick="reload()">Reload
				</button>
				</sec:authorize>		 		
		 	</div>
		</div>
 	</div>
</div>











