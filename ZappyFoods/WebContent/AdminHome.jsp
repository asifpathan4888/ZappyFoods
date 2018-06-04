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

								<ul class="nav navbar-nav navbar-right">
									<li><a href="#slider">Home</a></li>
									<li><a href="#footer_widget">Add Product</a></li>
									<li><a href="ViewAllProduct">View All Product</a></li>
									<li><a href="PendingOrder.jsp">View Pending Orders</a></li>
									<li><a href="ViewAllOrder.jsp">View All Order</a></li>
									<li><a href="ViewAllRegisteredCustomer">View All Registered
											Customers</a></li>
									<li><a href="AdminLogout">Logout</a></li>


								</ul>
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

	<section id="slider" class="slider">
		<div class="slider_overlay">
			<div class="container">
				<div class="row">
					<div class="main_slider text-center">
						<div class="col-md-12">
							<div class="main_slider_content wow zoomIn"
								data-wow-duration="1s">
								<h2>ADMIN HOME</h2>
								<h4>Zappy Foods</h4>
								<h4>Makes You Happy</h4>
								<p>Zappy is a product of Anand Bhog Foods Pvt. Ltd.
									Established in the year 2013, Anand Bhog has always emphasized
									on offering food products that are 100% pure quality food
									products. That’s why Anand Bhog is a name that has become
									synonymous with purity and taste today.</p>
								<button href="" class="btn-lg">Click here</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>








	<section id="footer_widget" class="footer_widget">
		<div class="container">
			<div class="row">
				<div class="footer_widget_content text-center">
					<div class="col-md-4">
						<div class="single_widget wow fadeIn" data-wow-duration="5s">
							<h2>ADD PRODUCT</h2>

							<div class="single_widget_form text-left">
								<form action="AddProductCtl" method="post" enctype="multipart/form-data" id="formid">
									<div class="form-group">
										<input type="text" class="form-control" name="productname"
											placeholder="ENTER PRODUCT NAME" required="">
									</div>

									<div class="form-group">
										<input type="text" class="form-control" name="category"
											placeholder="ENTER CATEGORY" required="">
									</div>

									<div class="form-group">
										<input type="text" class="form-control" name="productprice"
											placeholder="ENTER PRODUCT PRICE" required="">
									</div>

									<div class="form-group">
										<input type="text" class="form-control" name="weight"
											placeholder="ENTER WEIGHT" required="">
									</div>


									<div class="form-group">
										<textarea class="form-control" name="description" rows="3"
											placeholder="DESCRIPTION"></textarea>
									</div>
									
									<div class="form-group">
								
										Image <input type="file" class="form-control" name="filename" accept=".jpg"/>
									</div>
									<!-- end of form-group -->



									<input type="submit" value="SUBMIT" class="btn btn-primary">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section id="viewallproduct" class="viewallproduct">
		<div class="container">
			<div class="row">
				<div class="viewallproduct_content text-center">

					<center>
						<h2>VIEW ALL PRODUCT</h2>
						<table>
							<tr>
								<th>Product ID</th>
								<th>Product Name</th>
								<th>Category</th>
								<th>Product Price</th>
								<th>Weight</th>
								<th>Description</th>
								<th>Image</th>
							</tr>
							
							<%
							ArrayList<Product> list=(ArrayList<Product>)request.getAttribute("data");
									if(list!=null){
							
							for(Product p : list){
							%>
							<tr>
							    <td><%=p.getProductId()%></td>
								<td><%=p.getProductname() %></td>
								<td><%=p.getCategory() %></td>
								<td><%=p.getProductprice()%></td>
								<td><%=p.getWeight() %></td>
								<td><%=p.getDescription()%></td>
								<td><img src="imgupload/<%=p.getImage()%>" height="100" width="100"></td>
								<td><a href ="Delete?ProductId=<%=p.getProductId() %>">Delete</a></td>
								<td><a href ="Pid?ProductId=<%=p.getProductId() %>">Update</a></td>
							</tr>
							<%
							}}%>
						</table>
						<p>&nbsp;</p>
					</center>
				</div>
			</div>
		</div>

	</section>






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

	<div class="scrollup">
		<a href="#"><i class="fa fa-chevron-up"></i></a>
	</div>


	<script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
	<script src="assets/js/vendor/bootstrap.min.js"></script>

	<script src="assets/js/jquery-easing/jquery.easing.1.3.js"></script>
	<script src="assets/js/wow/wow.min.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
