<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>



<div class="showUsersTrainings container">
	<div class="row">
		<div id="trainingListTable"
			class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10">			
			<h2>Choose one from your training</h2>
			
			<form method='GET'>
				<table class="table">
					<thead>
						<tr>
							<th>Username</th><th>Email</th><th>Role</th><th>Enabled</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><c:out value="${user.userName}"></c:out></td>
								<td><c:out value="${user.userEmail}"></c:out></td>
								<td><c:out value="${user.authority}"></c:out></td>
								<td><c:out value="${user.enabled}"></c:out></td>
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

	
		
	