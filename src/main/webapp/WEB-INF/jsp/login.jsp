 <%@page contentType="text/html" pageEncoding="windows-1252"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/icons/favicon.ico" />" / >
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/iconic/css/material-design-iconic-font.min.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/animate/animate.css" />">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/css-hamburgers/hamburgers.min.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/animsition/css/animsition.min.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/select2/select2.min.css" />">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/daterangepicker/daterangepicker.css" />">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />">
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form modelAttribute="logindto" action="${pageContext.request.contextPath}/ceklogin" method="post">
					<span class="login100-form-title p-b-26">
						Welcome
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<form:input path="username" type="text" class="input100" />
						<span class="focus-input100" data-placeholder="Username"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<form:input path="password" type="password" class="input100" />
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Login
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Don’t have an account?
						</span>

						<a class="txt2" href="#">
							Sign Up
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
	<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/animsition/js/animsition.min.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/bootstrap/js/popper.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/select2/select2.min.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/daterangepicker/moment.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/vendor/daterangepicker/daterangepicker.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/countdowntime/countdowntime.js" />"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>