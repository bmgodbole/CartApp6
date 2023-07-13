package com.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bg.model.DiscountItem;

public class DiscountItemDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DiscountItemDao(Connection con)
	{
		this.con = con;
	}

   public DiscountItem getItemDiscountObj(int pid) 
   {
	   DiscountItem discitem = null;
	   query = "Select * from item_discount where prod_d_id = ?";
	   try {
			pst = this.con.prepareStatement(query);
		    pst.setInt(1, pid);
		    rs=pst.executeQuery();
		
		while(rs.next())
		{
			discitem = new DiscountItem();
			discitem.setDisc_id(rs.getInt("disc_id"));
			discitem.setProd_d_id(rs.getInt("prod_d_id"));
			discitem.setDiscount_val(rs.getInt("discount_val"));
			discitem.setDiscount_percent(rs.getInt("discount_percent"));
		    discitem.setValid_until(rs.getDate("valid_until").toString());
		}
		
		
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	return discitem;
	   
   }
}
