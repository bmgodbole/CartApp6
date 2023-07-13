package com.bg.model;

public abstract class PercentDiscountType {
	public  abstract int applyDiscount(int amount) ;

}

 class MemberDiscount extends PercentDiscountType
{

	@Override
	public int applyDiscount(int amount) {
		int discAmount = (amount * 5 )/100;
		return discAmount;
		// TODO Auto-generated method stub
		//5% discount
	}
}	
	 class SellerDiscount extends PercentDiscountType
	 {

	 	@Override
	 	public int applyDiscount(int amount) {
	 		int discAmount = (amount * 2 )/100;
			return discAmount;
			
	 		// TODO Auto-generated method stub
	 	//2% discount
	 		
	 	}

}
	 class CuponDiscount extends PercentDiscountType
	 {

		@Override
		public int applyDiscount(int amount) {
			int discAmount = (amount * 10 )/100;
			return discAmount;
			
			// TODO Auto-generated method stub
			//flat 10% off
		}
		 
	 }