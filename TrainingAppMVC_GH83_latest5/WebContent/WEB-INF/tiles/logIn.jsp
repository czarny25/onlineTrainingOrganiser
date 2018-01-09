<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script type="text/javascript">
	$(document).ready(function() {
		document.f.j_username.focus();
	});
</script>




<div class="logInFormContainer   container-fluid">
	<div class="logInFormBox">
		<div>
			<h1 class="login-title text-center">Login</h1>
		</div>
		<div>
			<c:if test="${param.error != null}">
				
				<span class="error">Login failed</span>
			
			</c:if>		
			<form class="form-signin" name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>

				<input type="text" name='j_username' placeholder="UserName">
				<input type="password" name='j_password' placeholder="Password">

				<button class="btn btn-lg btn-block" type="submit"
					value="Login">Sign in</button>
			</form>
		</div>
		<div class="checkbox">
			<label><input type="checkbox" name='_spring_security_remember_me'>Remember me</label>
		</div>
		<div class="new-account">
			<a href="<c:url value="/createNewAccount"/>">Create an account </a>
		</div>
	</div>
</div>




















