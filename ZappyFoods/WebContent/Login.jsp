<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<html class="no-js" lang="">
<!--<![endif]-->
<head>

<%
response.addHeader("pragma", "no-cache");
response.addHeader("cache-control", "no-store");
response.addHeader("expire", "0");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script>alert("<%=msg%>");</script>

<%} %>




<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>ZappyFoods</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->


<!--For Plugins external css-->
<link rel="stylesheet" href="assets/css/animate/animate.css" />
<link rel="stylesheet" href="assets/css/plugins.css" />

<!--Theme custom css -->
<link rel="stylesheet" href="assets/css/style.css">

<!--Theme Responsive css-->
<link rel="stylesheet" href="assets/css/responsive.css" />

<script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
</style>

</head>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div class='preloader'>
		<div class='loaded'>&nbsp;</div>
	</div>
	<header id="home" class="navbar-fixed-top">
		<div class="header_top_menu clearfix">
			<div class="container">
				<div class="row">
					<div class="col-md-5 col-md-offset-3 col-sm-12 text-right">
						<div class="call_us_text">
							<a href=""><i class="fa fa-clock-o"></i> Order Foods 24/7</a> <a
								href=""><i class="fa fa-phone"></i> 7400550734</a>
						</div>
					</div>

					<div class="col-md-4 col-sm-12">
						<div class="head_top_social text-right">
							<a href=""><i class="fa fa-facebook"></i></a> <a href=""><i
								class="fa fa-google-plus"></i></a> <a href=""><i
								class="fa fa-twitter"></i></a> <a href=""><i
								class="fa fa-linkedin"></i></a> <a href=""><i
								class="fa fa-pinterest-p"></i></a> <a href=""><i
								class="fa fa-youtube"></i></a> <a href=""><i class="fa fa-phone"></i></a>
							<a href=""><i class="fa fa-camera"></i></a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- End navbar-collapse-->

		<div class="main_menu_bg">
			<div class="container">
				<div class="row">
					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1"
									aria-expanded="false">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
								<a class="navbar-brand our_logo" href="#"><img
									src="assets/images/logo.png" alt="" /></a>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1">

								<!-- <ul class="nav navbar-nav navbar-right">
									<li><a href="#slider">Home</a></li>
									<li><a href="#footer_widget">Add Product</a></li>
									<li><a href="ViewAllProduct">View All Product</a></li>
									<li><a href="#portfolio">View Pending Orders</a></li>
									<li><a href="#mobaileapps">View All Order</a></li>
									<li><a href="#mobaileapps">View All Registered
											Customers</a></li>
									<li><a href="#mobaileapps">Logout</a></li>


								</ul> -->
							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.container-fluid -->
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- End Header Section -->









	<section id="login" class="login">
		<div class="container">
			<div class="row">
				<div class="login_content text-center">
					<div class="col-md-4">
						<div class="single_widget wow fadeIn" data-wow-duration="5s">
						<%
						HttpSession sesion =request.getSession();
						String s = (String) request.getAttribute("msg");
									if(s!=null)
									
								out.println(s);
						%>
						
							<h2>LOGIN FORM</h2>
							

							<div class="single_widget_form text-left">
							
								<form action="LoginCtl" method="get" id="formid">
									<div class="form-group">
										<input type="text" class="form-control" name="email"
											placeholder="ENTER EMAIL" required="">
									</div>

									<div class="form-group">
										<input type="password" class="form-control" name="pass"
											placeholder="ENTER PASSWORD" required="">
									</div>

									<input type="submit" value="SUBMIT" class="btn btn-primary">
									<input type="reset" value="RESET" class="btn btn-primary">
									<div class="form-group">
								</form>
								
<!-- <a href="AdminHome.jsp">Home</a> -->
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


<h6><a href="Register.jsp">SIGNUP</a></h6> <h6><a href="Home.jsp">HOME</a></h6>

<!-- <h6><a href="ChangePassword.jsp">Change Password</a></h6> --> 
<h6><a href="Forgotpassword.jsp">Forgot Password</a></h6>






	<!--Footer-->
	<footer id="footer" class="footer">
		<div class="container text-center">
			<div class="row">
				<div class="col-sm-12">
					<div class="copyright wow zoomIn" data-wow-duration="3s">
						<p>
							Copyright ® 2018 Zappyfoods.in All rights reserved.<br>
							Developed and Powered by Asif Khan Pathan
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
	<script src="assets/js/vendor/bootstrap.min.js"></script>

	<script src="assets/js/jquery-easing/jquery.easing.1.3.js"></script>
	<script src="assets/js/wow/wow.min.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
