<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="bean.PlacedOrderBean"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>ORDER PLACED</title>
</head>
<body>



<%ArrayList<PlacedOrderBean> al = (ArrayList<PlacedOrderBean>)request.getAttribute("data");
if(al.isEmpty()){
	out.println("ORDERED IS CONFIRMED  AND CHECK YOUR E-MAIL");
	
}	for(PlacedOrderBean b : al){ %>
			<h3>Your Order Has Been Placed </h3>
			<p>Order Id :- <%=b.getId()%>  </p>
			<p>Order Date :-<%=b.getDate() %></p>
			<p>Amount:-Rs <%=b.getAmount()%></p>
			<p>Payment Method:- Cash On Delivery </p><br/><br/><br/>
			<%} %>
			

</body>
</html>