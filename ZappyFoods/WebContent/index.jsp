<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
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
        <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
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
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
		<div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <header id="home" class="navbar-fixed-top">
            <div class="header_top_menu clearfix">	
                <div class="container">
                    <div class="row">	
                        <div class="col-md-5 col-md-offset-3 col-sm-12 text-right">
                            <div class="call_us_text">
								<a href=""><i class="fa fa-clock-o"></i> Order Foods 24/7</a>
								<a href=""><i class="fa fa-phone"></i> 7400550734</a>
							</div>
                        </div>

                        <div class="col-md-4 col-sm-12">
                            <div class="head_top_social text-right">
                                <a href=""><i class="fa fa-facebook"></i></a>
                                <a href=""><i class="fa fa-google-plus"></i></a>
                                <a href=""><i class="fa fa-twitter"></i></a>
                                <a href=""><i class="fa fa-linkedin"></i></a>
                                <a href=""><i class="fa fa-pinterest-p"></i></a>
                                <a href=""><i class="fa fa-youtube"></i></a>
                                <a href=""><i class="fa fa-phone"></i></a>
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
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                    <a class="navbar-brand our_logo" href="#"><img src="assets/images/logo.png" alt="" /></a>
                                </div>
								<%String user=(String)session.getAttribute("user"); %>
                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="Home.jsp">Home</a></li>
                                        <li><a href="#abouts">About Us</a></li>
                                        <%if(user==null){ %>
                                        <li><a href="Login.jsp">Login</a></li>
                                        <%}else{ %>
                                        <li><a>Welcome To <%=user%></a></li>
                                        <%} %>
                                        
									    
                                        <li><a href="#portfolio">Store</a></li>
                                         <li><a href="ViewCartCtl">Cart</a></li>
                                        <li><a href="ChangePassword.jsp">Change Password</a></li>
										 <li><a href="#features">Spreading Happiness</a></li>
										 <li><a href="#footer_widget">Contact Us</a></li>
                                         <li><a href="CustomerLogoutCtl">Logout</a></li>
                                       
                                    </ul>
                                </div><!-- /.navbar-collapse -->
                            </div><!-- /.container-fluid -->
                        </nav>
                    </div>
                </div>
            </div>	
        </header> <!-- End Header Section -->

        <section id="slider" class="slider">
            <div class="slider_overlay">
                <div class="container">
                    <div class="row">
                        <div class="main_slider text-center">
                            <div class="col-md-12">
                                <div class="main_slider_content wow zoomIn" data-wow-duration="1s">
                                
                                    <h5>WELCOME TO CUSTOMER </h5>
                                    <h1>Zappy Foods </h1>
                                    <h1>Makes You Happy </h1>
                                    <p>Zappy is a product of Anand Bhog Foods Pvt. Ltd. Established in the year 2013, Anand Bhog has always emphasized on offering food products that are 100% pure quality food products. That’s why Anand Bhog is a name that has become synonymous with purity and taste today.</p>
                                    <button href="" class="btn-lg">Click here</button>
                                </div>
                            </div>	
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <section id="abouts" class="abouts">
            <div class="container">
                <div class="row">
                    <div class="abouts_content">
                      <div class="col-md-6">
                            <div class="single_abouts_text wow slideInRight" data-wow-duration="1s">
                                <h4>About us</h4>
                                <h3>What's Zappy? </h3>
                                <p>We live in the net age, where everything is smart, fast and easy; then   why should our cooking be the same tedious time-consuming chore. Zappy   brings the ultimate convenience into the kitchen with a veritable range   of Ready to Eat, Drink and Cook products.<br>
Zappy makes you happy by   taking the stress out of cooking. Surprise your family and friends with   the tastiest snacks, drinks and desserts. All prepared in a few minutes   with practically no effort at all.<br>
All Zappy products are made with   natural ingredients with a special packing that retains the freshness   and taste. Plus, every recipe has been carefully selected to give you   the best in taste and health.<br>
Now, don’t worry about ‘What to cook   today?’ any more. Just open a Zappy pack and see your family glow with   happiness, or should we say, zappiness!</p>

                                <a href="" class="btn btn-primary">click here</a>
                            </div>
                      </div>
                  </div>
                </div>
            </div>
        </section>
		
		
		
		
		
		
		
		
		
		<!-- <section id="login" class="login">
		<div class="container">
			<div class="row">
				<div class="login_content text-center">
					<div class="col-md-4">
						<div class="single_widget wow fadeIn" data-wow-duration="5s">
						
						
							<h2>LOGIN FORM</h2>

							<div class="single_widget_form text-left">
								<form action="  " method="post" id="formid">
									<div class="form-group">
										<input type="text" class="form-control" name="uname"
											placeholder="ENTER USERNAME" required="">
									</div>

									<div class="form-group">
										<input type="text" class="form-control" name="pass"
											placeholder="ENTER PASSWROD" required="">
									</div>


									
									<input type="submit" value="SUBMIT" class="btn btn-primary">
									<input type="reset" value="RESET" class="btn btn-primary">
									<div class="form-group">
								</form>
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

		 -->
		
		
		
		
		
		
		

        <section id="features" class="features">
            <div class="slider_overlay">
                <div class="container">
                    <div class="row">
                        <div class="main_features_content_area  wow fadeIn" data-wow-duration="3s">
                            <div class="col-md-12">
                                <div class="main_features_content text-left">
                                    <div class="col-md-6">
                                        <div class="single_features_text">
                                            <div>
                                              <h2>Zappy is all about Spreading Happiness</h2>
                                              <p>Zappy is an endeavor to not just spread happiness amongst our   customers, but also to take small steps towards making the world a   better place. Bringing amazing instant food products to you brings us a   lot of happiness (Zappyness we call it!) and therefore we want to share   it with the world. Just like the products we make, happiness can be   instant too if we all joined hands together.</p>
                                              <p>We know, it doesn’t take a lot of effort to bring a smile on   someone’s face, and that is what we aim to achieve. With this thought,   we join hands with <strong>Smile Foundation</strong> to work for the education, health and welfare of underprivileged children in India.</p>
                                              <p>Zappy is a part of <strong>Mission Education - Smile Foundations’</strong> ongoing initiative to provide education to needy students. Through   Cause Related Marketing, Zappy will provide financial assistance to this   project. Every pack of Zappy that you buy, we will contribute Re. 1 to   Smile <strong>Mission Education.</strong></p>
                                            </div>
                                            <a href="" class="btn btn-primary">click here</a>
                                      </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="portfolio" class="portfolio">
            <div class="container">
                <div class="row">
                    <div class="portfolio_content text-center  wow fadeIn" data-wow-duration="5s">
                        <div class="col-md-12">
                            <div class="head_title text-center">
                                <h4>Delightful</h4>
                                <h3>Experience</h3>
                            </div>

                            <div class="main_portfolio_content">
                               <%@page import="java.util.ArrayList,model.AdminModel,bean.Product" %>
                             <%
                             ArrayList<Product> list=  new AdminModel().getAllProductData();
                           
                                            		  for(Product p:list)
                                            		  {
                                            		  %>
                                <div class="col-md-3 col-sm-4 col-xs-6 single_portfolio_text">
                                    <img src="imgupload/<%=p.getImage()%>" height="300px" width="200px"  alt="" />
                                    <div class="portfolio_images_overlay text-center">
                                        <h6><%=p.getProductname() %> </h6>
                                        <h6><%=p.getProductprice() %></h6>
                                        <h6><%=p.getDescription()%></h6>
                                        <a href="CartCtl?pid=<%=p.getProductId()%>&productname=<%=p.getProductname()%>&quantity=1" class="btn btn-primary">ADD TO CART </a></div>
                                </div>
                               <%
                               }
                               %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    
    <section id="admin" class="admin">
		<div class="container">
			<div class="row">
				<div class="admin_content text-center">
					<div class="col-md-4">
						<div class="single_widget wow fadeIn" data-wow-duration="5s">
						
						
							<h2>ADMIN FORM</h2>

							<div class="single_widget_form text-left">
								<form action="AdminLogin" method="post" id="formid">
									<div class="form-group">
										<input type="text" class="form-control" name="uid"
											placeholder="ENTER USERNAME" required="">
									</div>

									<div class="form-group">
										<input type="password" class="form-control" name="pwd"
											placeholder="ENTER PASSWROD" required="">
									</div>


									
									<input type="submit" value="SUBMIT" class="btn btn-primary">
									<input type="reset" value="RESET" class="btn btn-primary">
									<div class="form-group">
								</form>
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    
    
        
        
        <section id="footer_widget" class="footer_widget"><div class="container"><div class="row"><div class="footer_widget_content text-center"><div class="col-md-4"><div class="single_widget wow fadeIn" data-wow-duration="2s"><div class="single_widget_info"></div>

                                <div class="footer_socail_icon">
                                    <a href=""><i class="fa fa-facebook"></i></a>
                                    <a href=""><i class="fa fa-google-plus"></i></a>
                                    <a href=""><i class="fa fa-twitter"></i></a>
                                    <a href=""><i class="fa fa-linkedin"></i></a>
                                    <a href=""><i class="fa fa-pinterest-p"></i></a>
                                    <a href=""><i class="fa fa-youtube"></i></a>
                                    <a href=""><i class="fa fa-phone"></i></a>
                                    <a href=""><i class="fa fa-camera"></i></a>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="single_widget wow fadeIn" data-wow-duration="4s">
                                <h3>Contact Us</h3>

                                <div class="single_widget_info">
                                    <p><span class="date_day">Monday To Friday</span>
                                        <span>8:00am to 10:00pm(Breakfast)</span>
                                        <span>11:00am to 10:00pm(Lunch/Diner)</span>

                                        <span class="date_day">Saturday & Sunday</span>
                                        <span>10:00am to 11:00pm(Brunch)</span>
                                        <span>11:00am to 12:00pm(Lunch/Dinner)</span></p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="single_widget wow fadeIn" data-wow-duration="5s">
                                <h3>Take it easy with location</h3>

                                <div class="single_widget_form text-left">
                                    <form action="#" id="formid">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="name" placeholder="first name" required="">
                                        </div>

                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" placeholder="Email" required="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Subject">
                                        </div> <!-- end of form-group -->

                                        <div class="form-group">
                                            <textarea class="form-control" name="message" rows="3" placeholder="Message"></textarea>
                                        </div>

                                        <input type="submit" value="click here" class="btn btn-primary">
                                    </form>	
                                </div>
                            </div>
                        </div>
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
							<p>Copyright ® 2018 Zappyfoods.in All rights reserved.<br>
Developed and Powered by Asif Khan Pathan </p>
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
