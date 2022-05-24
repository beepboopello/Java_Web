<%-- 
    Document   : login
    Created on : May 6, 2022, 2:55:47 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Welcome</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style_1.css">

	</head>
	<body>
	<section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Welcome to our shop</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="wrap">
                            <div class="img" style="background-image: url(img/download.jpg);"></div>
                                <div class="login-wrap p-4 p-md-5">
                                    <div class="d-flex">
                                        <div class="w-100">
                                            <h3 class="mb-4">Sign Up</h3>
                                        </div>
                                            <div class="w-100">
                                                    <p class="social-media d-flex justify-content-end">
                                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                                                    </p>
                                            </div>
                                    </div>
                                        <form action="register" method="post" class="signin-form">
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="user" required>
                                                    <label class="form-control-placeholder" for="username">Username</label>
                                            </div>
                                            <div class="form-group">
                                                    <input id="password-field" type="password" name="pass" class="form-control" required>
                                                    <label class="form-control-placeholder" for="password">Password</label>
                                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                            </div>
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="fname" required>
                                                    <label class="form-control-placeholder" for="username">First name</label>
                                            </div>
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="lname" required>
                                                    <label class="form-control-placeholder" for="username">Last name</label>
                                            </div>
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="email" required>
                                                    <label class="form-control-placeholder" for="username">email</label>
                                            </div>
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="address" required>
                                                    <label class="form-control-placeholder" for="username">Address</label>
                                            </div>
                                            <div class="form-group mt-3">
                                                    <input type="text" class="form-control" name="phone" required>
                                                    <label class="form-control-placeholder" for="username">Phone number</label>
                                            </div>
                                            <div class="form-group" >
                                                <button type="submit" class="form-control btn btn-primary rounded submit px-3" style="background: #D19C97 !important" >Sign Up</button>
                                            </div>
                                            
                                          </form>
                  <!--<p class="text-center">Not a member? <a data-toggle="tab" href="register.jsp"style="color: #D19C97 !important">Sign Up</a></p>-->
                </div>
               </div>
                </div>
                </div>
            </div>
    </section>

   <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>


