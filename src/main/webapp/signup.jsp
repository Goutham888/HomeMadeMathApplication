<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="AutoMotive Template">
    <meta name="keywords" content="AutoMotive, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Homemade Math</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles from the template-->
    
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/elegant-icons.css" rel="stylesheet" media="screen">
    <link href="resources/css/nice-select.css" rel="stylesheet" media="screen">
    <link href="resources/css/jquery-ui.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/magnific-popup.css" rel="stylesheet" media="screen">
    <link href="resources/css/owl.carousel.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/slicknav.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/style.css" rel="stylesheet" media="screen">
    
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>


    <!-- Header Section Begin -->
    <header class="header">

        <div class="container">
            <div class="row">
                <div class="col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="index.jsp">Home</a></li>
                            <li class="active"><a href="downloadAlg1.jsp">Worksheets</a></li>
                            <li class="active"><a href="login.jsp">Login</a></li>
                            <li class="active"><a href="signup.jsp">Sign Up</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    
        <section class="products spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2 style="color:black">Sign Up</h2>
                        <br>	
                        	<!-- Just sends inputted data back to UserController.java -->
                       		<form action="signup" method="post">
                       			<p>	
                       				You don't need to sign up to download the worksheets on our websites. 
                       				We have this here so we can alert you when we add a new worksheet.
                       				<br><br>
									Enter username: <input type="text" name="uname">
									<br><br>
									Enter password: <input type="password" name="pass">
									<br><br>
									Enter first name: <input type="text" name="firstName">
									<br><br>
									Enter last name: <input type="text" name="lastName">
									<br><br>
									Enter email: <input type="email" id="email" size="30" name="email" required>
									<br><br>
									<input type="submit" value="Sign Up"><br><br>
								</p>
							</form>
                    </div>
                </div>
             </div>
        </div>
        </section>
    <!-- Hero Section End -->

   

    <!-- Footer Section Begin -->
    <footer class="footer set-bg" style="background-color:black;">
    <!-- data-setbg="img/footer-bg.jpg"  this goes inside the footer tag upstairs-->
        <div class="container">
            
            <div class="footer__text" >
                <div class="row" >
                    
                    
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__news">
                            <h5>Contact Us</h5>
                            <a href="#" class="footer__news__item">
                                Email:
                                <span>goutham.mitta@gmail.com</span>
                            </a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- All from the template -->
    <div class="footer__copyright">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <div class="footer__copyright__text">
                        <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                    </div>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
                <div class="col-md-4">
                    <div class="footer__copyright__social">
                        <a href="#"><span class="social_facebook"></span></a>
                        <a href="#" class="twitter"><span class="social_twitter"></span></a>
                        <a href="#" class="vimeo"><span class="social_vimeo"></span></a>
                        <a href="#" class="pinterest"><span class="social_pinterest"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer Section End -->

    <!-- Js Plugins from the template-->
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.magnific-popup.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
    <script src="resources/js/jquery.nice-select.min.js"></script>
    <script src="resources/js/jquery.slicknav.js"></script>
    <script src="resources/js/owl.carousel.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>

</html>