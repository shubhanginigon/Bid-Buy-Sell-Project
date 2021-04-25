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
    <a class="navbar-brand" href="/home">AIT - Bid Buy Sell</a
    >
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
          <a class="nav-link active" href="/home">Home</a>
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

  <body>
  <div class="content">
    <div class="container">
      <div class="row">
        <div id="bidModal" class="modal">

          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Place your Bid</h5>
            </div>
            <%--                                    <span class="close">&times;</span>--%>
            <div class="modal-body">
              <p>Product ID: ${product.pid}</p>
              <p>Product Name: ${product.name}</p>
              <p>Starting Price: ${product.price}</p>
              <form action="/bid" method="post" modelAttribute="bid">
                <div class="form-group">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">$</span>
                    </div>
                    <input type="text" name="price" class="form-control" aria-label="Amount (to the nearest dollar)" required aria-valuemin="${product.price}">
                    <div class="input-group-append">
                      <span class="input-group-text">.00</span>
                    </div>
                  </div>
                  <input name="status" value="Ongoing" hidden>
                  <input name="product_id" value="${product.pid}" hidden>
                  <div class="mb-3">
                    <input type="submit" class="btn btn-info btn-lg" value="Bid">
                  </div>
                </div>
              </form>

            </div>
            <div class="modal-footer">
              <p>Last Bid: 12000 &nbsp; Bidder: Shubhi</p>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

  </body>
</html>
