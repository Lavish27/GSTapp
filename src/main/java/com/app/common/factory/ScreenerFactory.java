package com.app.common.factory;

public class ScreenerFactory {
	public static Screener getSaleScreener() {
		return new Screener(Portal.RETAIL.getId(), ScreenerName.SALE.getId());
	}
	
	public static Screener getPurchaseScreener() {
		return new Screener(Portal.RETAIL.getId(), ScreenerName.PURCHASE.getId());
	}
	
	public static class Screener{
		private final String portal;
		private final String screener;
		
		Screener(String portal, String screener){
			this.portal = portal;
			this.screener = screener;
		}
		
		public String getPortal() {
			return portal;
		}
		
		public String getScreener() {
			return screener;
		}
	}
	
	private enum Portal{
		RETAIL("retailer-side");
		
		private final String id;
		Portal(String id){
			this.id = id;
		}
		public String getId() {
			return id;
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
