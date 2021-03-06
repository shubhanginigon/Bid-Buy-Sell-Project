<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register Screen</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css" />
    <link rel="stylesheet" href="assets/css/Footer-Basic.css" />
    <link rel="stylesheet" href="assets/css/Navigation-with-Button.css" />
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="/home">AIT - Bid Buy Sell</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link active" href="/home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Rules</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Tutorials</a></li>
                <li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>
            </ul>
            <span class="navbar-text actions"> 
            	<a class="login" href="/login">Log In</a>
            	<a class="btn btn-light action-button" role="button" href="/register">Register</a>
            </span>
        </div>
    </div>
</nav>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"></div>
        <form:form action="/register" method="post" modelAttribute="user">
            <h2 class="text-center"><strong>Create</strong> an account.</h2>
            <spring:bind path="name">
                <div class="form-group">
                    <form:input path="name" class="form-control" type="text" name="name" placeholder="Full Name" />
                    <form:errors class="text-danger small" path="name" />
                    <div class="text-danger small"></div>
                </div>
            </spring:bind>


            <div class="form-group">
                <form:select path="gender" items="${genders}" class="custom-select" name="gender" />
            </div>

            <spring:bind path="email">
                <div class="form-group">
                    <form:input path="email" class="form-control" type="email" name="email" placeholder="Email" />
                    <form:errors class="text-danger small" path="email" />
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group">
                    <form:input path="password" class="form-control" type="password" name="password" placeholder="Password" />
                    <form:errors class="text-danger small" path="password" />
                </div>
            </spring:bind>
            <spring:bind path="confirmPassword">
                <div class="form-group">
                    <form:input path="confirmPassword" class="form-control" type="password" name="confirmPassword" placeholder="Confirm Password" />
                    <form:errors class="text-danger small" path="confirmPassword" />
                </div>
            </spring:bind>

            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Register</button>
            </div>
            <a class="already" href="/login">You already have an account? Login here.</a>
        </form:form>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>