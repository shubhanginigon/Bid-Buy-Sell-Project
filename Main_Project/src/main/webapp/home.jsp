<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"
	href="/Progress Project Presentation/logo.ico">

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>AIT - Bid Buy Sell</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/Footer-Basic.css" />
<link rel="stylesheet" href="assets/css/Navigation-with-Button.css" />
<link rel="stylesheet" href="assets/css/styles.css" />
<link rel="stylesheet" href="assets/css/Team-Boxed.css" />
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
					role="button" href="/register">Register</a>
				</span>
			</div>
		</div>
	</nav>
	<div class="team-boxed">
		<div class="container">

			<div class="row product-list">

				<c:forEach items="${products}" var="product">
					<div class="gift row col-12 product-list-item">
						<div class="gift__img col-sm-3 col-12">
							<img class="product-img" src="assets/img/gift_01.jpg"
								alt="product image" />
						</div>
						<div class="gift__info col-sm-9 col-12">
							<h4 class="gift__name">${product.name}</h4>
							<div class="gift__details">
								<p>${product.description}</p>
							</div>
							<div class="gift__bottom row">
								<div class="gift__price-wrap col-12 col-sm-6">
									<div class="gift__normal-price"></div>
									<div class="gift__today-price">
										<span>Current Price: </span><span class="gift__data">THB
											${product.price}</span>
									</div>
									<div class="gift__quantity-left">
										<span>Bid starts on: </span><span class="gift__data">${product.startDate}</span>
									</div>
									<div class="gift__quantity-left">
										<span>Bid ends on: </span><span class="gift__data">${product.finishDate}</span>
									</div>
								</div>
								<div class="gift__cta-wrap col-12 col-sm-6">
									<a class="btn btn-info" target="_self" href="/login">BID</a><br>
									<span class="gift__cta-note">12 people currently bidding</span>
								</div>
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
