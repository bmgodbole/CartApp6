package com.bg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.connection.DbCon;
import com.bg.dao.OrderDao;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancel_order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    
		try(PrintWriter pw = response.getWriter())
		{
			String id1 = request.getParameter("id");
			if(id1 != null)
			{
			   int id = Integer.parseInt(id1);
			   OrderDao orderDao = new OrderDao(DbCon.getConnection());
				orderDao.cancelOrder(id);
			}

			response.sendRedirect("order.jsp");
		}
		catch(Exception e)
		{
			
		}
	
	}

}
