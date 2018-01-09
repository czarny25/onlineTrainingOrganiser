			
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