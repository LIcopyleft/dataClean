package com.drcnet.mc.bigdata.bmap.Utils;

import java.text.DecimalFormat;

public class AngleUtils {
	
	 private final static double Rc=6378137;
	 private final static double Rj=6356725;
	 
	 private static double EARTH_RADIUS = 6378137;//赤道半径(单位m)
	 private static final double INTEGR_NUM = 10000;

	 /**
	 * 基于googleMap中的算法得到两经纬度之间的距离,误差 <= 0.2m
	 * @param lat1 第一点的精度
	 * @param lng1 第一点的纬度
	 * @param lat2 第二点的精度
	 * @param lng2 第二点的纬度
	 * @return 返回的距离，单位m
	 * */

//	 public static double distance(double lat1, double lng1, double lat2, double lng2) {
//		 lat1 = Math.abs(lat1);
//		 lng1 = Math.abs(lng1);
//		 lng2 = Math.abs(lng2);
//	    	lat2 = Math.abs(lat2);
//		 double x1 = Math.cos(lat1) * Math.cos(lng1);
//		 double y1 = Math.cos(lat1) * Math.sin(lng1);
//		 double z1 = Math.sin(lat1);
//		 double x2 = Math.cos(lat2) * Math.cos(lng2);
//		 double y2 = Math.cos(lat2) * Math.sin(lng2);
//		 double z2 = Math.sin(lat2);
//		 double lineDistance =
//		 Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
//		 double s = EARTH_RADIUS * Math.PI * 2 * Math.asin(0.5 * lineDistance) / 180;
//		 return Math.round(s * INTEGR_NUM) / INTEGR_NUM;
//	 }
	 
	 /*
	 计算两个经纬度之间的距离  结果单位：米
	  */
	 public static double  distance(double lat1, double lng1, double lat2, double lng2) {
//	     Double lat1 = Double.parseDouble(lat1Str);
//	     Double lng1 = Double.parseDouble(lng1Str);
//	     Double lat2 = Double.parseDouble(lat2Str);
//	     Double lng2 = Double.parseDouble(lng2Str);

	     double radLat1 = rad(lat1);
	     double radLat2 = rad(lat2);
	     double a = radLat1 - radLat2;
	     double b = rad(lng1) - rad(lng2);
	     double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
	             Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	     s = s * EARTH_RADIUS;
	     s = Math.round(s * 10000) / 10000;
	     return s;
	 }


	

	 private static double rad(double d) {
	     return d * Math.PI / 180.0;
	 }

	/**
     * 已知两点经纬度求方位角
     */
    public static double getAngle(double lon1, double lat1, double lon2,
                                  double lat2) {
    	lon1 = Math.abs(lon1);
    	lat1 = Math.abs(lat1);
    	lon2 = Math.abs(lon2);
    	lat2 = Math.abs(lat2);
        double fLat = Math.PI * (lat1) / 180.0;
        double fLng = Math.PI * (lon1) / 180.0;
        double tLat = Math.PI * (lat2) / 180.0;
        double tLng = Math.PI * (lon2) / 180.0;
 
        double degree = (Math.atan2(Math.sin(tLng - fLng) * Math.cos(tLat), Math.cos(fLat) * Math.sin(tLat) - Math.sin(fLat) * Math.cos(tLat) * Math.cos(tLng - fLng))) * 180.0 / Math.PI;
        if (degree >= 0) {
            return degree;
        } else {
            return 360 + degree;
        }
    }
    
    
  /*  public AngleUtils(){
        m_RadLo=longitude*Math.PI/180.;
        m_RadLa=latitude*Math.PI/180.;
        Ec=Rj+(Rc-Rj)*(90.- latitude)/90.;
        Ed=Ec*Math.cos(m_RadLa);
    }*/
 
    /**
     * 求B点经纬度
     * @param A 已知点的经纬度，
     * @param distance   AB两地的距离  单位km
     * @param angle  AB连线与正北方向的夹角（0~360）
     * @return  B点的经纬度
     */
    public static double[] getMyLatLng(double longitude,double latitude, double distance, double angle){
    	double m_RadLo,m_RadLa;
        double Ec;
        double Ed;
    	m_RadLo=longitude*Math.PI/180.;
        m_RadLa=latitude*Math.PI/180.;
        Ec=Rj+(Rc-Rj)*(90.- latitude)/90.;
        Ed=Ec*Math.cos(m_RadLa);
        double dx = distance*Math.sin(Math.toRadians(angle));
        double dy= distance*Math.cos(Math.toRadians(angle));
        double bjd=(dx/Ed+m_RadLo)*180./Math.PI;
        double bwd=(dy/Ec+m_RadLa)*180./Math.PI;
//        return new LatLng(bwd,bjd);
        System.out.println(bjd);
        System.out.println(bwd);
        double[] latandlng= {bwd,bjd};
        return latandlng;
    }
    
    
    /** 地球半径 **/
    private static final double R = 6371e3;
    /** 180° **/
    private static final DecimalFormat df = new DecimalFormat("0.000000");

    /**
     * 根据一点的坐标与距离，以及方向，计算另外一点的位置
     * @param angle 角度，从正北顺时针方向开始计算
     * @param startLong 起始点经度
     * @param startLat 起始点纬度
     * @param distance 距离，单位m
     * @return
     */
    public static String[] calLocationByDistanceAndLocationAndDirection( double startLong,double startLat, double distance,double angle){
//    	startLong = Math.abs(startLong);
//    	startLat = Math.abs(startLat);
      String[] result = new String[2];
      //将距离转换成经度的计算公式
      double δ = distance/R;
      // 转换为radian，否则结果会不正确
      angle = Math.toRadians(angle);
      startLong = Math.toRadians(startLong);
      startLat = Math.toRadians(startLat);
      double lat = Math.asin(Math.sin(startLat)*Math.cos(δ)+Math.cos(startLat)*Math.sin(δ)*Math.cos(angle));
      double lon = startLong + Math.atan2(Math.sin(angle)*Math.sin(δ)*Math.cos(startLat),Math.cos(δ)-Math.sin(startLat)*Math.sin(lat));
      // 转为正常的10进制经纬度
      lon = Math.toDegrees(lon);
      lat = Math.toDegrees(lat);
      result[0] = df.format(lon);
      result[1] = df.format(lat);
      System.out.println(result[0]+"--"+ result[1]);
      return result;
    }

    public static void main(String[] args) {
    	System.out.println(distance(-77.455811,38.9445330, 116.586944,40.0722220));
//    	System.out.println(getMyLatLng(110.346723423, 41.489923423423,1500*1000,getAngle(110.346723423, 41.489923423423, 126.96881111, 45.868121212)));
    	System.out.println(calLocationByDistanceAndLocationAndDirection(-77.455811, 38.9445330,
    			1415*1000,getAngle(77.455811, 38.9445330, 116.586944, 40.0722220)));
	}
    
    
    
    public static void getLatLng(Double startLat,Double startLng,Double endLat,Double endLng){
    	//y=ax+b
    	
    	
    }
}
