<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap MyTheme CSS -->
<link href="${css}/bootstrap.min.mytheme1.css" rel="stylesheet">

<!-- Bootstrap MyTheme CSS 
<link href="${css}/datatables.css" rel="stylesheet">
-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->
			<c:if test="${userClickHome ==true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout ==true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact ==true }">
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if test="${userClickCategoryProducts==true or userClickAllProducts==true}">
				<%@include file="listproducts.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		<!-- Data Tables -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data Tables -->
		<script src="${js}/datatables.js"></script>
		
		<script src="${js}/myapp.js"></script>
		

	</div>
</body>

</html>
