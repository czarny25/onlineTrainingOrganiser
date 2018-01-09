<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div class="logInFormContainer   container-fluid">
	<div class="createAccountFormBox">
		<div>
			<h1 class="text-center create-title">Create new user account</h1>
		</div>
		<div>
			<f:form class="form-createAccount"
				action="${pageContext.request.contextPath}/doCreateAccount"
				method="post" commandName="user">

				<f:input name="userName" type="text" path="userName"
					placeholder="UserName" />
				<br />
				<f:errors path="userName" cssClass="error"></f:errors>
				<f:input name="userEmail" type="text" path="userEmail"
					placeholder="User Email" />
				<br />
				<f:errors path="userEmail" cssClass="error"></f:errors>
				<f:input id="password" name="password" type="text" path="password"
					placeholder="Password" />
				<br />
				<f:errors path="password" cssClass="error"></f:errors>
				<input id="confirmpassword" name="confirmpassword" type="text"
					placeholder="Confirm Password" />
				<div id="passConfirm"></div>


				<button class="btn btn-lg btn-primary btn-block" type="submit"
					value="Create account">Create account</button>
			</f:form>
		</div>

	</div>
</div>
