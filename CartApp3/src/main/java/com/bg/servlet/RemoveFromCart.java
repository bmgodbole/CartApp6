package com.bg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.model.CartItem;
import com.bg.model.Order;
import com.bg.model.User;

/**
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/remove-from-cart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //response.getWriter().print(request.getParameter("id"));
	    int id = Integer.parseInt(request.getParameter("id"));
	    //ArrayList<CartItem> cart_list  = (ArrayList<CartItem>)request.getSession().getAttribute("cart-list");
	    if (id >0) {
			ArrayList<CartItem> cart_list = (ArrayList<CartItem>) request.getSession().getAttribute("cart-list");
			if (cart_list != null) {
				for (CartItem c : cart_list) {
					if (c.getItemId() == id) {
						cart_list.remove(cart_list.indexOf(c));
						break;
					}
				}
			}
			response.sendRedirect("cart.jsp");

		} else {
			response.sendRedirect("cart.jsp");
		}
	 
	}
}
