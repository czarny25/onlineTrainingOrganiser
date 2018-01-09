<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
	<script type="text/javascript">
		
	
		window.onscroll = function () {
			myFunction();
		}
		
		function myFunction() {
		    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
		    	//alert("dupa");
		    	$(".navbar-inverse").css("background", "#1a1a1a");
		    } else {
		    	
		    	$(".navbar-inverse").css("background","transparent");
		    }
		}
		
		
		
		
	</script>


<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container-fluid" >
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
			 data-toggle="collapse" data-target="#collapsemenu" aria-expanded="false">
			 	<span class="sr-only">Toggle navigation</span>
			 	<span class="icon-bar"></span>
			 	<span class="icon-bar"></span>
			 	<span class="icon-bar"></span>
			</button>
			<sec:authorize access="!isAuthenticated()">
				<a href="<c:url value='/'/>" class="gymLogo">
					<img src="static/images/gymLogo12.png">
				</a>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value='/homePage'/>" class="gymLogo">
					<img src="static/images/gymLogo12.png">
				</a>
			</sec:authorize>
			
		</div>
			
		<div class="collapse navbar-collapse" id="collapsemenu">
			<ul class="nav navbar-nav">
				<li >
					<sec:authorize access="!isAuthenticated()">
						<a href="${pageContext.request.contextPath}/">Home</a>
					</sec:authorize>
				</li>
				<li >
					<sec:authorize access="isAuthenticated()">
						<a href="${pageContext.request.contextPath}/homePage">Home</a>
					</sec:authorize>
				</li>
				
				<li><a href="${pageContext.request.contextPath}/about">About</a></li>
				
				<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
				
				
				<li>				  
				   <sec:authorize access="!isAuthenticated()">
					 <button class="btn btn-default navbar-btn" onclick="window.location.href='<c:url value='/logIn'/>'">
					 <span class="glyphicon glyphicon-log-in"></span> Login</button>
				   </sec:authorize>
				 </li>
				  
				 <li>
				   <sec:authorize access="isAuthenticated()">
					 <button class="btn btn-default navbar-btn" onclick="window.location.href='<c:url value='/j_spring_security_logout'/>'">
					 <span class="glyphicon glyphicon-log-out"></span> Log out</button>
				   </sec:authorize>
				 </li>
				
				
				
			</ul>
			
		</div>
	
	</div>
</nav>



