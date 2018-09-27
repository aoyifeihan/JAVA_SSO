package com.sso.util;

/**
 * ͨ����ͼ�ϵ��������������루Java�汾��
 * Add by �ɳ���С��Jason.Song�� on 2017/11/01
 * http://blog.csdn.net/jasonsong2008
 */
public class MapHelper {
    /**
     * ����뾶
     */
    private static double EarthRadius = 6378.137;

    /**
     * ��γ��ת���ɻ���
     * Add by �ɳ���С��Jason.Song�� on 2017/11/01
     * http://blog.csdn.net/jasonsong2008
     *
     * @param d ����/γ��
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * �������������֮��ľ���
     * Add by �ɳ���С��Jason.Song�� on 2017/11/01
     * http://blog.csdn.net/jasonsong2008
     *
     * @param firstLatitude   ��һ�������γ��
     * @param firstLongitude  ��һ������ľ���
     * @param secondLatitude  �ڶ��������γ��
     * @param secondLongitude �ڶ�������ľ���
     * @return ��������֮��ľ��룬��λ������/ǧ��
     */
    public static double getDistance(double firstLatitude, double firstLongitude,
                                     double secondLatitude, double secondLongitude) {
        double firstRadLat = rad(firstLatitude);
        double firstRadLng = rad(firstLongitude);
        double secondRadLat = rad(secondLatitude);
        double secondRadLng = rad(secondLongitude);

        double a = firstRadLat - secondRadLat;
        double b = firstRadLng - secondRadLng;
        double cal = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(firstRadLat)
                * Math.cos(secondRadLat) * Math.pow(Math.sin(b / 2), 2))) * EarthRadius;
        double result = Math.round(cal * 10000d) / 10000d;
        return result;
    }

    /**
     * �������������֮��ľ���
     * Add by �ɳ���С��Jason.Song�� on 2017/11/01
     * http://blog.csdn.net/jasonsong2008
     *
     * @param firstPoint  ��һ�������ģ�γ��,���ȣ� ���磺"31.2553210000,121.4620020000"
     * @param secondPoint �ڶ��������ģ�γ��,���ȣ� ���磺"31.2005470000,121.3269970000"
     * @return ��������֮��ľ��룬��λ������/ǧ��
     */
    public static double GetPointDistance(String firstPoint, String secondPoint) {
        String[] firstArray = firstPoint.split(",");
        String[] secondArray = secondPoint.split(",");
        double firstLatitude = Double.valueOf(firstArray[0].trim());
        double firstLongitude = Double.valueOf(firstArray[1].trim());
        double secondLatitude = Double.valueOf(secondArray[0].trim());
        double secondLongitude = Double.valueOf(secondArray[1].trim());
        return getDistance(firstLatitude, firstLongitude, secondLatitude, secondLongitude);
    }


}
