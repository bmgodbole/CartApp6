package com.bg.model;

public class DiscountItem {

	private int disc_id ;
	private int prod_d_id ;
	private String  valid_until;
	private int discount_val;
	private int discount_percent;
	public int getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(int disc_id) {
		this.disc_id = disc_id;
	}
	public int getProd_d_id() {
		return prod_d_id;
	}
	public void setProd_d_id(int prod_d_id) {
		this.prod_d_id = prod_d_id;
	}
	public String getValid_until() {
		return valid_until;
	}
	public void setValid_until(String valid_until) {
		this.valid_until = valid_until;
	}
	public int getDiscount_val() {
		return discount_val;
	}
	public void setDiscount_val(int discount_val) {
		this.discount_val = discount_val;
	}
	public int getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(int discount_percent) {
		this.discount_percent = discount_percent;
	}
}
