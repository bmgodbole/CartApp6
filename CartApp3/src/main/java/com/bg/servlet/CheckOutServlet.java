package com.bg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out = response.getWriter())
		{
			System.out.println("checkout servlet"); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = new Date();
			//retrieve all cart products
			ArrayList<CartItem> cart_list = (ArrayList<CartItem>)request.getSession().getAttribute("cart-list");
			//retrieve user
			User auth = (User)request.getSession().getAttribute("auth");
			
			//check auth and cart list
			if(auth!=null && cart_list !=null )
			{
				int Ordertotal = 0;
				OrderDao oDao=new OrderDao(DbCon.getConnection());
				for(CartItem c : cart_list)
				{
					
					String dt1 = formatter.format(date);
					//prepare order object
					Order order = new Order();
					order.setItemId(c.getItemId());
					order.setUid(auth.getUser_id());
					order.setQuantity(c.getQuantity());
					order.setOrderTotal(0);
				    order.setDate(dt1);
				    order.setOrderTotal(c.getTotal_price());
				    Ordertotal=Ordertotal+c.getTotal_price();
				    if(c.getDisc_obj()!=null)
				    {
				    System.out.println("discount : "+c.getDisc_obj().getDiscount_percent());
				    order.setOrderDiscount((c.getPrice()*c.getDisc_obj().getDiscount_percent()/100)*c.getQuantity());
				    order.setOrderActualAmt(c.getTotal_price()-(c.getPrice()*c.getDisc_obj().getDiscount_percent()/100)*c.getQuantity());
				    }
				    else 
				    {
				    	order.setOrderDiscount(0);
				    	order.setOrderActualAmt(c.getTotal_price());
				    }
				    //(c.getPrice()*c.getQuantity()-(c.getPrice()*c.getDisc_obj().getDiscount_val()/100));
				    //instantiate dao class
				    System.out.println("Ord..."+order);
				    boolean result = oDao.insertOrder(order);
				    if(!result)
				    {
				    	break;
				    }
				   
				    
				}
				 cart_list.clear();
				 out.print("order total: "+Ordertotal);
				 response.sendRedirect("order.jsp");
			}else {
				if(auth == null)
				{
					response.sendRedirect("login.jsp");
				}
				else
				{
					response.sendRedirect("cart.jsp");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
