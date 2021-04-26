<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
    />
    <title>AIT - Bid Buy Sell</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css" />
    <link rel="stylesheet" href="../assets/css/Footer-Basic.css" />
    <link rel="stylesheet" href="../assets/css/Navigation-with-Button.css" />
    <link rel="stylesheet" href="../assets/css/styles.css" />
    <link rel="stylesheet" href="../assets/css/Team-Boxed.css" />
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container">
        <a class="navbar-brand" href="/home">AIT - Bid Buy Sell</a
        ><button
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

<div class="team-boxed">
    <div class="container">
        <div class="row">
            <div class="form-container">
                <div class="image-holder"></div>
                <form:form action="/product/add" method="post" modelAttribute="product">
                    <h2 class="text-center">Add new product.</h2>
                    <spring:bind path="name">
                        <div class="form-group">
                            <form:input path="name" class="form-control" type="text" name="name" placeholder="Product Name" />
                            <form:errors class="text-danger small" path="name" />
                            <div class="text-danger small"></div>
                        </div>
                    </spring:bind>

                    <spring:bind path="price">
                        <div class="form-group">
                            <form:label path="price">Price:</form:label>
                            <form:input path="price" class="form-control" type="number" name="name" placeholder="Price" />
                            <form:errors class="text-danger small" path="price" />
                            <div class="text-danger small"></div>
                        </div>
                    </spring:bind>

                    <spring:bind path="description">
                        <div class="form-group">
                            <form:input path="description" class="form-control" type="text" name="description" placeholder="Description" />
                            <form:errors class="text-danger small" path="description" />
                        </div>
                    </spring:bind>

                    <spring:bind path="picture">
                        <div class="form-group">
                            <form:label path="finishDate_">Bid Finish Date:</form:label>
                            <form:input path="picture" class="form-control-file" type="file" name="picture" />
                            <form:errors class="text-danger small" path="picture" />
                        </div>
                    </spring:bind>
                    <spring:bind path="startDate_">
                        <div class="form-group">
                            <form:label path="startDate_">Bid Start Date:</form:label>
                            <form:input path="startDate_" class="form-control" type="datetime-local" name="startDate_" />
                            <form:errors class="text-danger small" path="startDate_" />
                        </div>
                    </spring:bind>

                    <spring:bind path="finishDate_">
                        <div class="form-group">
                            <form:label path="finishDate_">Bid Finish Date:</form:label>
                            <form:input path="finishDate_" class="form-control" type="datetime-local" name="finishDate_" />
                            <form:errors class="text-danger small" path="finishDate_" />
                        </div>
                    </spring:bind>

                    <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit">Add</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>