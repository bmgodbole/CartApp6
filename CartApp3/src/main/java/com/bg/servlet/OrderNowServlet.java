package com.bg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.connection.DbCon;
import com.bg.dao.OrderDao;
import com.bg.model.CartItem;
import com.bg.model.Order;
import com.bg.model.User;

/**
 * Servlet implementation class OrderNowServlet
 */
@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("order now doget");
		//int id = Integer.parseInt(request.getParameter("id"));
	    String id1 = (String) request.getParameter("id");
        System.out.println("order now id1 "+id1);
	    
        int id = Integer.parseInt(id1);
		ArrayList<CartItem> cart_list  = (ArrayList<CartItem>)request.getSession().getAttribute("cart-list");
	    User auth = (User) request.getSession().getAttribute("auth");
	    System.out.println("order now cart_list "+cart_list);
	    System.out.println("order now user "+auth);
	    if(auth !=null)
	    {
	    	Order orderModel = new Order();
	    	System.out.println("order now line 48 :");
	       if(id>0)
	       {
	    	   int qty = 1;
	    	   if ( request.getParameter("quantity") != null)
	    	   {
	    	     qty = Integer.parseInt( request.getParameter("quantity"));
	    	   }
	    	  
	    	   
	    	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = new Date();


	    	   String dt = formatter.format(date);
	    	   System.out.println("order now qty"+qty);
	           //orderModel.setOrderId(id); //id should come from database
	           //right now setting it equal to product id.
	           orderModel.setQuantity(qty);
	           orderModel.setDate(dt);
	           //use formatter for date
	           orderModel.setUid(auth.getUser_id()); 
	           orderModel.setItemId(id);
	           System.out.println("order now user set ordermodel ");
	           for(CartItem c:cart_list)
	           {
	        	   if(id==c.getItemId())
	        	   {
	        	       orderModel.setOrderTotal(c.getTotal_price());
	        	    //   System.out.println("dis:"+c.getDisc_obj().getDiscount_percent());
	        	       cart_list.remove(cart_list.indexOf(c));
	        	       break;
	        	   }
	           }
	         //call orderdao to insert order in database
	           try {
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				boolean result = orderDao.insertOrder(orderModel);
				if(result)
				{
					 response.sendRedirect("order.jsp");
					 System.out.println("order now line 76 : order success");
				}
				else
				{
					response.getWriter().print("order failed");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	    
	        }
	    else {
	        response.sendRedirect("login.jsp");
	    }
	 }
	    else {
	        response.sendRedirect("login.jsp");
	    } 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("order now dopost");
		doGet(request, response);
	}

}
