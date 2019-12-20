<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title><link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/login.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<body>
<div class="text-center" style="padding:50px 0">
	<div class="logo">login</div>
		 <p  class="text-danger"><c:out value="${loginError}" /></p>
	<!-- Main Form -->
	
			<div class="login-form-1">
			<form method="post" action="/login" id="login-form" class="text-left" >
				
					<div class="login-form-main-message"></div>
					<div class="main-login-form">
					
						<div class="login-group">
					
						  
							<div class="form-group">
								<label for="email" for="lg_username" class="sr-only">Email</label>
								<input type="email" class="form-control" id="lg_username" name="email" placeholder="email">
							</div>
							<div class="form-group">
								<label for="password" for="lg_password" class="sr-only">Password</label>
								<input type="password" class="form-control" id="lg_password" name="password" placeholder="password">
							</div>
							<div class="form-group login-group-checkbox">
								<input type="checkbox" id="lg_remember" name="lg_remember">
								<label for="lg_remember">remember</label>
							</div>
						</div>
						<div class="text-center ">
							  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                     <button type="submit" class=" btn btn-block send-button tx-tfm">Login</button>
		                  </div>
		                 
						<div class="form-group">
		                     <a class="btn btn-block g-button" href="#">
		                     <i class="fa fa-google"></i> Sign up with Google
		                     </a>
		                  </div>
		                  
					</div>
					</form>
				
			</div>
			<!-- end:Main Form -->
		</div>

<!-- REGISTRATION FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">Register</div>
	  <p class="text-danger"><c:out value="${registrationError}" /></p>
    	<p  class="text-danger"><form:errors path="user.*"/></p>
	<!-- Main Form -->
	<div class="login-form-1">
		
		 <form:form method="POST" action="/registration" modelAttribute="user" id="register-form" class="text-left">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
				
					<div class="form-group">
						<form:label path="username"  class="sr-only">Username</form:label>
						<form:input path="username" type="text" class="form-control"   placeholder="username"/>
					</div>
					<div class="form-group">
						<form:label path="email" class="sr-only">Email</form:label>
						<form:input path="email" type="text" class="form-control" placeholder="email" />
					</div>
					<div class="form-group">
						<form:label path="password"  class="sr-only">Password</form:label>
						<form:input path="password" type="password" class="form-control" placeholder="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirmpassword"   class="sr-only">Password Confirmation</form:label>
						<form:input path="confirmpassword" type="password" class="form-control" placeholder="confirm password"/>
					</div>
				
					
				
					
					<!------
					<div class="form-group login-group-checkbox">
						<input type="radio" class="" name="reg_gender" id="male" placeholder="username">
						<label for="male">male</label>
						
						<input type="radio" class="" name="reg_gender" id="female" placeholder="username">
						<label for="female">female</label>
					</div> 
					---------->
					
					<div class="form-group login-group-checkbox">
						<input type="checkbox" class="" id="reg_agree" name="reg_agree">
						<label for="reg_agree">i agree with <a href="#">terms</a></label>
					</div>
				</div>
				</div><div class="text-center ">
                     <button type="submit" class=" btn btn-block send-button tx-tfm">Create an Account</button>
                  </div>
			<div class="etc-login-form">
				<p>already have an account? <a href="#">login here</a></p>
			</div>
		 </form:form>
	</div>
	<!-- end:Main Form -->
</div>
</body>
</html>