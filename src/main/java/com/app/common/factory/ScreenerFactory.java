package com.app.common.factory;

public class ScreenerFactory {
	public static Screener getSaleScreener() {
		return new Screener(ScreenerName.SALE.getId());
	}
	
	public static Screener getPurchaseScreener() {
		return new Screener(ScreenerName.PURCHASE.getId());
	}
	
	public static class Screener{
		private final String screener;
		
		Screener(String screener){
			this.screener = screener;
		}
		
		
		public String getScreener() {
			return screener;
		}
	}
	
	
	private enum ScreenerName{
		SALE("sale-screener"),
		PURCHASE("purchase-screener");
		
		private final String id;
		ScreenerName(String id){
			this.id = id;
		}
		public String getId() {
			return id;
		}
			
	}

}
