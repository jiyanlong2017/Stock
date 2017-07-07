package com.stock.core.utils;

/**
 * 常量
 */
public class Consts {
    public static final String PREFERENCE_NAME = "com.yjwl.ehome.prefs";

    // 测试用的Json接口，返回郑州天气Json数据
    public static final String TEST_URL = "http://www.weather.com.cn/data/sk/101180101.html";

    public static final String APP_ENAME = "ehome";

    public static final String APP_CNAME = "e居管家";

    //指定cache的文件目录名称
    public static final String CACHE_FILE_NAME = "ehome";

    /**
     * 公司网站地址
     */
    public static final String COMPANY_WEB_SITE = "http://www.ehome9.com";

    /**
     * 基地址
     */
//    public static final String BASE_URL = "http://115.29.144.113:8080/ics_service";
    public static final String BASE_URL = "http://192.168.0.129:8080/ics_service";


    /**
     * 充电指引地址
     */
    public static final String HELP_SOCKT = COMPANY_WEB_SITE;

    /**
     * 开门指引地址
     */
    public static final String HELP_DOOR = COMPANY_WEB_SITE;

    /**
     * 服务条款地址
     */
    public static final String SERVICE_URL = BASE_URL + "";


    /**
     * 保密协议地址
     */
    public static final String SECURITY_URL = BASE_URL + "";

    /**
     * 版权信息地址
     */
    public static final String COPYRIGHT_URL = BASE_URL + "";

    /**
     * 计费规则地址
     */
    public static final String HELP_SOCKET_START = COMPANY_WEB_SITE;

    public static byte[] biv = {2, 1, 0, 2, 1, 3, 5, 4, 1, 5, 2, 6, 2, 7, 1, 8};
    public static String HEADER1 = "X-HLG-Key";
    public static String HEADER2 = "X-HLG-Sign";

    //H5请求附带的参数名称
    public static String H5_X1 = "x1";
    public static String H5_X2 = "x2";
    public static String H5_X3 = "x3";

    /**
     * 蓝牙门禁设备名的前缀
     */
    public final static String BLE_DEVICE_PREFIX = "ZG_EAC2.0";

//    public final static String PAY_NOTIFY_ALI = BASE_URL + "/notify/a";
    public final static String PAY_NOTIFY_ALI = "http://115.29.144.113:8080/ics_service" + "/notify/a";

    /**
     *  城市列表的缓存Key
     */
    public static final String CACHE_KEY_CITY_LIST = "citylist";

    /**
     *  小区列表的缓存Key
     *  +城市拼音
     */
    public static final String CACHE_KEY_GROUP_LIST = "grouplist";

}
