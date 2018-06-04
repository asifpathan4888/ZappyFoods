<%@page import="bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW CART</title>
</head>
<body>




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





<form action="ViewCartCtl" method="get">



<section id="viewcart" class="viewcart">
		<div class="container">
			<div class="row">
				<div class="viewcart_content text-center">

					<center>
						<h2>VIEW CART</h2>
						<table border="1">
							<tr>
								
								<th>S.NO</th>
								<th>Product Name</th>
								<th>Product Price</th>
								<th>Weight</th>
								<th>Quantity</th>
								<th>Image</th>
								<th>Remove</th>
								
								
							</tr>
							
							<%
							int total=0;
							ArrayList<CartBean> list=(ArrayList<CartBean>)request.getAttribute("data");
									if(list!=null){
										int x =1;
										
							for(CartBean c : list){
								int ttl  = Integer.parseInt(c.getProductPrice());
								total = total+ttl;
							%>
							<tr>
							    
								<td><%=x %></td>
								<td><%=c.getProductName() %></td>
								<td><%=c.getProductPrice()%></td>
								<td><%=c.getWeight() %></td>
								<td>
								
								<div class="quantity buttons_added">
  <input id="minus" type="button" class="minus" value="-">
  <input id="theInput" type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
  <input id="plus" type="button" class="plus" value="+">
</div>
<script>
var input = document.getElementById('theInput');
document.getElementById('plus').onclick = function(){
    input.value = parseInt(input.value, 10) +1
}
document.getElementById('minus').onclick = function(){
    input.value = parseInt(input.value, 10) -1
}
</script>
								<%=c.getQuantity() %></td>
								
								
								<td><img src="imgupload/<%=c.getImage()%>" height="100" width="100"></td>
								<td><a href ="RemoveCtl?ProductId=<%=c.getProductId()%>">Remove</a></td>
								
							</tr>
							<%
							x++;}}%>
						</table>
						Grand total = <%=total %>
						<p>&nbsp;</p>
					</center>
				</div>
			</div>
		</div>
		<center>
		
		<form action="Order" method="get">
		<inpuut type = "hidden" value = <%=total%> />
 <input type="button" value="PLACE ORDER" class="btn btn-primary" onclick="window.location='Order?amount= <%=total%>';">  <a href="index.jsp#portfolio">CONTINUE SHOPPING</a>
 </form>
</center>
	</section>


</form>













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