package com.app.repository.sql;

public class Queries {


	public static final String subtGoldStock = "update STOCK set quantity = quantity - :g_wt where type = 'Gold'";

	public static final String subtSilverStock = "update STOCK set quantity = quantity - :s_wt where type = 'Silver'";

	public static final String addGoldStock = "update STOCK set quantity = quantity + :g_wt where type = 'Gold'";

	public static final String addSilverStock = "update STOCK set quantity = quantity + :s_wt where type = 'Silver'";

}
