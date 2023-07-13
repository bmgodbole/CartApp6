package com.bg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bg.model.Order;
import com.bg.model.OrderDetail;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con)
	{
		this.con = con;
	}
	public boolean insertOrder(Order order)
	{
		boolean result = false;
		try {
			
			query = "insert into orders(product_id,user_id,quantity,order_date,order_total,order_discount,order_actual_amount) "
					+ "values(?,?,?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			//pst.setInt(1,order.getOrderId());
			pst.setInt(1, order.getItemId());
			pst.setInt(2, order.getUid());
			pst.setInt(3, order.getQuantity());
			String str=order.getDate();
			Date date=Date.valueOf(str);//converting string into sql date.

			pst.setDate(4,date);
			pst.setInt(5,order.getOrderTotal());
			pst.setInt(6,order.getOrderDiscount());
			pst.setInt(7, order.getOrderActualAmt());
			System.out.println("orderDao line 32: query");
			System.out.println(" query "+query);
			pst.executeQuery();
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	public List<OrderDetail> getuserOrderList(int id)
	{
		List<OrderDetail> userOrders = new ArrayList<OrderDetail>();
		
		try {
			
			query = "select o.order_id , o.order_date , o.quantity,o.order_total,"
					+ " o.order_discount,o.order_actual_amount , "
					+ " i.item_name as product_name ,i.item_id as product_id,u.user_id, u.user_email "
					+ " from orders o , items i ,users u"
					+ "	where o.product_id = i.item_id"
					+ " and o.user_id = u.user_id"
					+ " and u.user_id = ?"
					+ " order by order_date desc";
			System.out.println("orderDao query getuserorders: "+query);
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				OrderDetail orderDetail = new OrderDetail();
			
			   
			   orderDetail.setORDER_ID(rs.getInt("order_id"));
			   orderDetail.setORDER_DATE(rs.getString("order_date"));
			   orderDetail.setQUANTITY(rs.getInt("quantity"));
			   orderDetail.setORDER_TOTAL(rs.getInt("order_total"));
			   orderDetail.setPRODUCT_NAME(rs.getString("product_name"));
			   orderDetail.setPRODUCT_ID(rs.getInt("product_id"));
			   orderDetail.setUSER_ID(rs.getInt("user_id"));
			   orderDetail.setUSER_EMAIL(rs.getString("user_email"));
			   orderDetail.setORDER_DISCOUNT(rs.getInt("order_discount"));
			   orderDetail.setORDER_ACTUAL_AMT(rs.getInt("order_actual_amount"));
			   userOrders.add(orderDetail);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userOrders;
	}
	public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where order_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
	}
}
