<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register Screen</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#">AIT - Bid Buy Sell</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link active" href="/home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Rules</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Tutorials</a></li>
                <li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>
            </ul>
            <span class="navbar-text actions"> 
            	<a class="btn btn-light action-button" href="/login">Log In</a>
            	<a class="btn btn-light action-button" role="button" href="/register">Register</a>
            </span>
        </div>
    </div>
</nav>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"></div>
        <form:form method="post" modelAttribute="user">
            <h2 class="text-center"><strong>Create</strong> an account.</h2>
            <spring:bind path="name">
                <div class="form-group">
                    <input class="form-control" type="text" name="name" placeholder="Full Name" required="">
                </div>
            </spring:bind>

            <spring:bind path="gender">
                <div class="form-group">
                    <select class="custom-select" name="gender">
                        <option value="Male">Male</option>
                        <option value="Female" selected="">Female</option>
                    </select>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email" required="">
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group"><input class="form-control" type="password" name="password"
                                               placeholder="Password"
                                               required=""></div>
            </spring:bind>
            <spring:bind path="confirmPassword">
                <div class="form-group"><input class="form-control" type="password" name="confirmPassword"
                                               placeholder="Confirm Password" required=""></div>
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