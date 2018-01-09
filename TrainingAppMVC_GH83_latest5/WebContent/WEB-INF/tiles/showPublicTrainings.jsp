<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>






<div class="showPublicTrainings container">
	<div class="row">	
		<div id="trainingListTable"
			class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10">
			
			<h2>Try one of our free trainings</h2>

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

								<td><c:out value="${training.trainingName}"></c:out></td>
								<td><a
									href="${pageContext.request.contextPath}/presentExampleTraining?trainingName=${training.trainingName} ">Show</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>

			
            <br>
			<br>
			<div id="goBackLinks">
				<sec:authorize access="!isAuthenticated()">
					<a href="<c:url value='/createNewAccount'/>">Register now and create your own training</a>
					<br>
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



