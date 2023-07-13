<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bg.dao.OrderDao,com.bg.model.User,com.bg.connection.*,com.bg.model.OrderDetail,java.util.*" %>
    <%User auth = (User) request.getSession().getAttribute("auth");
    List<OrderDetail> userOrders=null;
    if(auth!=null)
    {
    	request.setAttribute("auth", auth);
    	OrderDao orderDao = new OrderDao(DbCon.getConnection());
    	userOrders = orderDao.getuserOrderList(auth.getUser_id());
    			
    }
    else
    {
    	response.sendRedirect("login.jsp");
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<div class=" container">
<div class="card-header my-3">Your Order has been placed</div></div>
<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Price</th>
					<th scope="col">Discount</th>
					<th scope="col">Actual Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			   if(userOrders != null)
			   for(OrderDetail ord:userOrders)	   
			   { %>
			   <tr>
				   <td><%=ord.getORDER_DATE() %></td>
				   <td><%=ord.getPRODUCT_NAME() %>
				   <td><%=ord.getQUANTITY() %>
				   <td><%=ord.getORDER_TOTAL() %>
				   <td><%=ord.getORDER_DISCOUNT() %>
				   <td><%=ord.getORDER_ACTUAL_AMT() %>
				   <td><a class="btn btn-sm btn-danger" href="cancel_order?id=<%=ord.getORDER_ID()%>">Cancel</a> </td>
				</tr>   
			  <%} %> 
		
			
			</tbody>
	    </table>
	    </div>
<%@include file="includes/footer.jsp" %>
</body>
</html>