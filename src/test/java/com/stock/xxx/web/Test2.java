package com.stock.xxx.web;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.stock.core.utils.HttpRequest;
import com.stock.core.utils.HttpUtils;
import com.stock.xxx.service.StockHistoryService;
import com.stock.xxx.vo.StockDataVo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.*;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiYanLong on 2017/3/8.
 */
public class Test2 {

    public static String url2 = "http://hq.sinajs.cn/list=sh";

    @org.junit.Test
    public void test(){
        String s = HttpRequest.sendGet(url2 + "600050", null);
        int i = s.indexOf("\"");
        int j = s.lastIndexOf("\"");
        String st = s.substring(i + 1, j);
        System.out.println(st);
    }

    @Test
    public void test3() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = simpleDateFormat.parse("2017-03-08").getTime();
        Timestamp timestamp = new Timestamp(time);
        System.out.print(timestamp);
    }

    @Test
    public void test4(){
        /*String host = "http://stock.market.alicloudapi.com";
        String path = "/sz-sh-stock-history";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE 170f06619df84e5c81e4e2b4a1b0edea");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("begin", "2017-03-01");
        querys.put("code", "600050");
        querys.put("end", "2017-03-09");


        try {
            *//**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             *//*
            HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);

            if(httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);
                StockDataVo json = JSON.parseObject(result, StockDataVo.class);
                System.out.print(json);
            }
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Test
    public void test5(){
        String name = "中国联通";
        int i = name.hashCode();
        String s = Integer.toHexString(i);
        System.out.println(name + "--hashcode:" + s);

    }


    public void test6(){

    }
    @org.junit.Test
    public void test7(){
        String replace = "渝 开 发".replace(" ", "");
        System.out.println(replace);
    }
}












