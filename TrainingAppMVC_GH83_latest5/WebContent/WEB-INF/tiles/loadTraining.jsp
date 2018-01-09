<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


		
		
	
		
		<script type="text/javascript">
		
		function loadTraining() {
			   
			var training = {
			   trainingName : "lydki",
			   weekDay    : "fri",
			   userName : "franek"
			   
	           
	        }
			$.ajax({
				url: "${pageContext.request.contextPath}/doLoad",
	            type: 'POST',
	            data:  training,
	            dataType: "json", 
	        });
			
		}
		
		</script>		

	
		 
	     <button  onclick="loadTraining()">Add training</button>	
	     
	      <p id="length"></p>	
	      
	      <p><a href="${pageContext.request.contextPath}/">Go back to home page</a></p>	
	   
	  
	   
	   
	   
	   
	    <p><a href="${pageContext.request.contextPath}/">Go back to home page now</a></p>	
	
	
		<!--  
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/loadMe.js"></script>
		
		-->
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/changePos11.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/displayWorking.js"></script>
	
	
	
	      
	      
	    
	
	
	
	
	
	