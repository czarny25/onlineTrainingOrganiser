<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<div class="guestPage container-fluid ">
	<div class="row">
		<div class="col-xs-offset-0 col-xs-12 col-sm-offset-2 col-sm-8">
			<h2>Welcome Guest</h2>
			<h2>Choose one from bellows options</h2>
			<ul class="listItems list-group">
				<li class="list-group-item"><a
					href="${pageContext.request.contextPath}/showTrainingExamples">View
						some Training examples</a></li>
				<li class="list-group-item"><sec:authorize
						access="!isAuthenticated()">
						<a href="<c:url value='/createNewAccount'/>">Register now and
							create your own training</a>
					</sec:authorize></li>
			</ul>
		</div>
	</div>

</div>






