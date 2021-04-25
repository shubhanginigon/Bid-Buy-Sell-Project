<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
    />
    <title>AIT - Bid Buy Sell</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css"/>
    <link rel="stylesheet" href="../assets/css/Footer-Basic.css"/>
    <link rel="stylesheet" href="../assets/css/Navigation-with-Button.css"/>
    <link rel="stylesheet" href="../assets/css/styles.css"/>
    <link rel="stylesheet" href="../assets/css/Team-Boxed.css"/>
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container">
        <a class="navbar-brand" href="/home">AIT - Bid Buy Sell</a>
        <button
                data-toggle="collapse"
                class="navbar-toggler"
                data-target="#navcol-1"
        >
          <span class="sr-only">Toggle navigation</span
          ><span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Rules</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Tutorials</a></li>
                <li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>
            </ul>
            <span class="navbar-text actions">
            Logged in as <strong>${user.name}!&nbsp; &nbsp;</strong>
            <a class="btn btn-danger text-white" href="/logout">Log Out</a>
          </span>
        </div>
    </div>
</nav>

<div class="content">
    <div class="container">
        <div class="row">
            <div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Starting Price</th>
                        <th scope="col">Current Bidding Price</th>
                        <th scope="col" colspan="2">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr class="table-default">
                            <th scope="row">${product.pid}</th>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>Current Bid Price</td>
                            <td>
                                <a href="" class="btn btn-primary">Edit</a>
                            </td>
                            <td>
                                <a href="" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>