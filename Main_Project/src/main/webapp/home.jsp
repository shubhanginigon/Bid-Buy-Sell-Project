<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png"
          href="/Progress Project Presentation/logo.ico">

    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>AIT - Bid Buy Sell</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/Footer-Basic.css"/>
    <link rel="stylesheet" href="assets/css/Navigation-with-Button.css"/>
    <link rel="stylesheet" href="assets/css/styles.css"/>
    <link rel="stylesheet" href="assets/css/Team-Boxed.css"/>
</head>

<body>
<nav
        class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container">
        <a class="navbar-brand" href="/home">AIT - Bid Buy Sell</a>
        <button data-toggle="collapse" class="navbar-toggler"
                data-target="#navcol-1">
            <span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link active" href="/home">Home</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Rules</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Tutorials</a></li>
                <li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>
            </ul>
            <span class="navbar-text actions"> <a class="login"
                                                  href="/login">Log In</a> <a class="btn btn-light action-button"
                                                                              role="button"
                                                                              href="/register">Register</a>
				</span>
        </div>
    </div>
</nav>
<div class="content">
    <div class="container">

        <div class="row">

            <c:forEach items="${products}" var="product">
                <div class="row product-row">
                    <div class="col-3">
                        <div>
                            <img class="product-img" src="assets/img/placeholder_image.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-8">
                        <h3>${product.name}</h3>
                            <p class="text-secondary">${product.description}</p>
                            <p><strong>Starting Price:</strong>${product.price}</p>
                            <p><strong>Bid Start Date:</strong>${product.startDate}</p>
                            <p><strong>Bid End Date:</strong>${product.finishDate}</p>
                    </div>
                    <div class="col-1">
                        <div class="bid-button">
                            <a href="/login" class="btn btn-info btn-lg">Bid</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
