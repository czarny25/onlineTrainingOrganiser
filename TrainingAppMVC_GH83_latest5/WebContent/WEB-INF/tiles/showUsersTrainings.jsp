<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>



<script type="text/javascript">



	function onReady() {
	
	
		//var trainingNamek = document.getElementsByClassName("tdName");
	
		//alert(" huj " + trainingNamek.nodeName);
	}

	$(document).ready(onReady);
	
	
	function reload(){
		
		var trainingNamek = document.getElementsByClassName("tdName");
		
		alert(" huj " + trainingNamek.nodeName);
		alert("delete");
		window.parent.location = window.parent.location.href;	
		
		
	}

</script>



<div class="showUsersTrainings container">
	<div class="row">
		<div id="trainingListTable"
			class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10">			
			<h2>Choose one from your training</h2>
			
			<form method='GET'>
				<table class="table">
					<thead>
						<tr>
							<th>Name of training</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="training" items="${trainings}">
							<tr>
								<td class="tdName"><c:out value="${training.trainingName}"></c:out></td>
								<td class="tdShow"><a 
									href="${pageContext.request.contextPath}/presentTraining?trainingName=${training.trainingName} ">Show</a>
								</td>
								<td>
									<a  href="${pageContext.request.contextPath}/deleteTraining?trainingName=${training.trainingName}&weekDay=${training.weekDay} ">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<br>
			<div id="goBackLinks">
				<sec:authorize access="!isAuthenticated()">
					<a href="<c:url value='/createNewAccount'/>">Register now and create your own training</a>
					<br>			
					<a href="<c:url value='/'/>">Go back to home page</a>
				</sec:authorize>
	
				<sec:authorize access="isAuthenticated()">
					<a href="<c:url value='/homePage'/>">Go back to home page</a>
				</sec:authorize>
			</div>

		</div>
	</div>
</div>







