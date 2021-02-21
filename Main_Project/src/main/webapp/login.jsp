<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
    />
    <title>Login Screen</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css" />
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css" />
    <link rel="stylesheet" href="assets/css/styles.css" />
  </head>

  <body>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
      <div class="container">
        <a class="navbar-brand" href="#">AIT - Bid Buy Sell</a
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
              <a class="nav-link active" href="/home">Home</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="#">Rules</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Tutorials</a></li>
            <li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>
          </ul>
          <span class="navbar-text actions">
            <a class="btn btn-light action-button" href="/login">Log In</a>
            <a
              class="btn btn-light action-button"
              role="button"
              href="/register"
              >Register</a
            >
          </span>
        </div>
      </div>
    </nav>
    <div class="login-clean">
      <form action="/login" method="POST">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-contact"></i></div>
        <div class="form-group">
          <input
            class="form-control"
            type="email"
            name="email"
            placeholder="Email"
            required=""
          />
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="password"
            name="password"
            placeholder="Password"
            required=""
          />
        </div>
        <div class="form-group">
          <button class="btn btn-primary btn-block" type="submit" name="submit">
            Log In
          </button>
        </div>
        <a class="forgot" href="#">Forgot your email or password?</a>
      </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
