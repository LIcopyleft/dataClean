package com.drcnet.mc.bigdata.bmap.constant;

import java.util.HashSet;
import java.util.Set;

public class Constant {
	
	public static String INDEX = "drc_series_info_index";
	public static String INDEXTYPE = "drc_series_info_index";

	public static String INDEXVALUES = "drc_series_values";
	public static String INDEXVALUESTYPE = "drc_series_values";
	
	public static String shipInex = "ship_info";
	public static String shipInexType = "ship_info";
	
	public static String shipVoyage = "ship_voyage";
	public static String shipVoyageType = "ship_voyage";
	
	public static String shipVoyageDynamic = "ship_voyage_dynamic";
	public static String shipVoyageDynamicType = "ship_voyage_dynamic";
	
	public static String DATABASE = "database";
	public static String INDICATOR = "indicator";
	public static String REGION = "region";
	public static String TIME = "time";
	public static String INDUSTRY = "industry";
	public static String EQUIPMENT = "equipment";
	public static String FROMREGION = "fromRegion";
	public static String TOREGION = "toRegion";
	public static String COMPANY = "company";
	public static String HS = "hs";
	public static String EDUCATION = "education";
	public static String POST = "post";
	
	public static String attribute = "attribute";
	public static String classify = "classify";
	public static String measure = "measure";
	public static String posc = "posc";
	public static String projstate = "projstate";
	public static String projtype = "projtype";
	public static String purchaseitem = "purchaseitem";
	public static String returnmode = "returnmode";
	
	public static Set<String> dimensionList = new HashSet<String>();
	
	static {
		dimensionList.add("region");
		dimensionList.add("fromRegion");
		dimensionList.add("toRegion");
		dimensionList.add("indicator");
		dimensionList.add("equipment");
		dimensionList.add("industry");
		dimensionList.add("hs");
		dimensionList.add("company");
		dimensionList.add("education");
		dimensionList.add("post");
		dimensionList.add("attribute");
		dimensionList.add("classify");
		dimensionList.add("measure");
		dimensionList.add("posc");
		dimensionList.add("projstate");
		dimensionList.add("projtype");
		dimensionList.add("purchaseitem");
		dimensionList.add("returnmode");
		dimensionList.add("planetype");
		dimensionList.add("airport");
		dimensionList.add("fromAirport");
		dimensionList.add("toAirport");
		dimensionList.add("enterprisetype");
		dimensionList.add("assetsscale");
		dimensionList.add("jtindustry");
		dimensionList.add("zoom");
		
		dimensionList.add("area");
		dimensionList.add("community");
		dimensionList.add("exponent");
		dimensionList.add("houseType");
		dimensionList.add("price");
		dimensionList.add("property");
		dimensionList.add("communityExponent");
		dimensionList.add("builttime");
		
		dimensionList.add("auction");
		dimensionList.add("bond");
		
		dimensionList.add("financial");
		dimensionList.add("reex");
		dimensionList.add("consume");
		dimensionList.add("interest");
		
		dimensionList.add("org");
		dimensionList.add("shop");
		dimensionList.add("crowd");
		dimensionList.add("loansType");
		dimensionList.add("harbor");
		dimensionList.add("fromHarbor");
		dimensionList.add("toHarbor");
		
	}
}
