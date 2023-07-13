package com.bg.model;

import java.sql.Date;

public class OrderDetail {

	int ORDER_ID ;                                  
	int PRODUCT_ID; 
	String PRODUCT_NAME;
	int USER_ID;            
	String USER_EMAIL;
	int ORDER_DISCOUNT;
	int ORDER_ACTUAL_AMT;
	public int getORDER_DISCOUNT() {
		return ORDER_DISCOUNT;
	}
	public void setORDER_DISCOUNT(int oRDER_DISCOUNT) {
		ORDER_DISCOUNT = oRDER_DISCOUNT;
	}
	public int getORDER_ACTUAL_AMT() {
		return ORDER_ACTUAL_AMT;
	}
	public void setORDER_ACTUAL_AMT(int oRDER_ACTUAL_AMT) {
		ORDER_ACTUAL_AMT = oRDER_ACTUAL_AMT;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	int QUANTITY;                                   
	String ORDER_DATE;                          
	int ORDER_TOTAL;
	public int getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public String getORDER_DATE() {
		return ORDER_DATE;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public void setORDER_DATE(String date) {
		ORDER_DATE = date;
	}
	public int getORDER_TOTAL() {
		return ORDER_TOTAL;
	}
	public void setORDER_TOTAL(int oRDER_TOTAL) {
		ORDER_TOTAL = oRDER_TOTAL;
	}
	
}
