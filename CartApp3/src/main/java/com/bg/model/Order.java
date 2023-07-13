package com.bg.model;

import java.util.Date;

public class Order {
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
		public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String dt) {
		this.date = dt;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	private int orderId;
	private int uid;
	private int quantity;
	private String date;
	private int orderTotal;
	private int orderDiscount;
	private int orderActualAmt;
    public int getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(int orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public int getOrderActualAmt() {
		return orderActualAmt;
	}
	public void setOrderActualAmt(int orderActualAmt) {
		this.orderActualAmt = orderActualAmt;
	}
	private int itemId;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", uid=" + uid + ", quantity=" + quantity + ", date=" + date
				+ ", orderTotal=" + orderTotal + ", orderDiscount=" + orderDiscount + ", orderActualAmt="
				+ orderActualAmt + ", itemId=" + itemId + "]";
	}
	
}
