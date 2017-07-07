package com.stock.xxx.utils;

import com.stock.core.utils.HttpRequest;
import com.stock.xxx.model.StockHistory;
import com.stock.xxx.model.StockStock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 股票抓取工具
 */
public class StockGrabUtils {

    public static String url = "http://quote.eastmoney.com/stocklist.html";

    public static String sh = "http://hq.sinajs.cn/list=sh";
    public static String sz = "http://hq.sinajs.cn/list=sz";

    public static Map<String, String> grab() throws IOException {

        Document document = Jsoup.connect(url).get();
        Element quotesearch = document.getElementById("quotesearch");
        Elements eles = quotesearch.getElementsByTag("ul");
        Map<String, String> map = new HashMap<String, String>();

        String reg = "\\(|\\)";
        for(Element e: eles){
            Elements as = e.getElementsByTag("a");
            for(Element a: as){
                String innertext = a.text();
                String[] s = innertext.split(reg);
                map.put(s[1], s[0]);
                System.out.println(s[0]+ " -- " + s[1]);
            }
        }
        System.out.println("共"+ map.size() +"只股票");
        return map;
    }


    public static StockHistory grab(StockStock stockStock) throws Exception {


        String stockCode = stockStock.getId();
        StockHistory stockHistory = new StockHistory();
        String url;
        if(stockCode.startsWith("6")){
            url = sh + stockCode;
        }else{
            url = sz + stockCode;
        }
        String result = HttpRequest.sendGet(url, null);
        int i = result.indexOf("\"");
        int j = result.lastIndexOf("\"");
        String s = result.substring(i + 1, j);
        String[] array = s.split(",");
        stockHistory.setStockname(array[0]);
        stockHistory.setKprice(new BigDecimal(array[1]));
        stockHistory.setSprice(new BigDecimal(array[2]));
        stockHistory.setCprice(new BigDecimal(array[3]));
        stockHistory.setHprice(new BigDecimal(array[4]));
        stockHistory.setLprice(new BigDecimal(array[5]));
        stockHistory.setJiheprice1(new BigDecimal(array[6]));
        stockHistory.setJiheprice2(new BigDecimal(array[7]));
        stockHistory.setVolume(new Long(array[8]));
        stockHistory.setTotalprice(array[9]);
        stockHistory.setMai1(Integer.valueOf(array[10]));
        stockHistory.setMai2(Integer.valueOf(array[12]));
        stockHistory.setMai3(Integer.valueOf(array[14]));
        stockHistory.setMai4(Integer.valueOf(array[16]));
        stockHistory.setMai5(Integer.valueOf(array[18]));
        stockHistory.setPrice1(new BigDecimal(array[11]));
        stockHistory.setPrice2(new BigDecimal(array[13]));
        stockHistory.setPrice3(new BigDecimal(array[15]));
        stockHistory.setPrice4(new BigDecimal(array[17]));
        stockHistory.setPrice5(new BigDecimal(array[19]));
        stockHistory.setPricea(new BigDecimal(array[21]));
        stockHistory.setPriceb(new BigDecimal(array[23]));
        stockHistory.setPricec(new BigDecimal(array[25]));
        stockHistory.setPriced(new BigDecimal(array[27]));
        stockHistory.setPricee(new BigDecimal(array[29]));
        stockHistory.setMaia(Integer.valueOf(array[20]));
        stockHistory.setMaib(Integer.valueOf(array[22]));
        stockHistory.setMaic(Integer.valueOf(array[24]));
        stockHistory.setMaid(Integer.valueOf(array[26]));
        stockHistory.setMaie(Integer.valueOf(array[28]));
        stockHistory.setCode(stockCode);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = simpleDateFormat.parse(array[30]).getTime();
        Timestamp timestamp = new Timestamp(time);
        stockHistory.setDate(timestamp);

        return stockHistory;
    }
}
