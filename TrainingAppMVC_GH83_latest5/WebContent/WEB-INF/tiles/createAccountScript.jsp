<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
			
			function onload(){				
				$("#password").keyup(comparePasswordEntry);
				$("#confirmpassword").keyup(comparePasswordEntry);
				$("#userInfo").submit(submitAllowed);
			}			
			function submitAllowed(){
				
				var password = $("#password").val();
				var confirmpassword = $("#confirmpassword").val();
				
				if(password != confirmpassword){
					return false;
				}else{
					return true;
				}				
			}
			
			function comparePasswordEntry(){				
				var password = $("#password").val();
				var confirmpassword = $("#confirmpassword").val();				
				
				if(password == confirmpassword){
					$("#passConfirm").text("<fmt:message key='CorrectPassword.user.password'/>");
					$("#passConfirm").addClass("valid");
					$("#passConfirm").removeClass("error");
				}else{
					$("#passConfirm").text("<fmt:message key='WrongPassword.user.password'/>");
					$("#passConfirm").addClass("error");
					$("#passConfirm").removeClass("valid");
				}				
			}
			
			$(document).ready(onload);			
			
</script>