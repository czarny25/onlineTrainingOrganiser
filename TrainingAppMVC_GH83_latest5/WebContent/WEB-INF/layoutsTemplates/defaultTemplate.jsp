<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">		
		<!-- <link href="${pageContext.request.contextPath}/static/normalize/temp.css" rel="stylesheet" type="text/css">
		 -->
		<link href="${pageContext.request.contextPath}/static/css/temp.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery.js"></script>
	
	</head>
	
	<body>
		<div >
			<div class="header">
				<tiles:insertAttribute name="header"></tiles:insertAttribute>
			</div>	
			<div class="mainContent ">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>		
			<div class="footer">
				<tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</div>
		</div>
		<!--  --> 		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery.js"></script>	
			
	</body>
</html>
	
	


