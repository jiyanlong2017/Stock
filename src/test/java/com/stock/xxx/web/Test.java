package com.stock.xxx.web;

import com.stock.core.jpa.SearchConst;
import com.stock.core.jpa.SearchFilter;
import com.stock.xxx.model.StockData;
import com.stock.xxx.model.StockHistory;
import com.stock.xxx.model.StockStock;
import com.stock.xxx.service.StockDataService;
import com.stock.xxx.service.StockHistoryService;
import com.stock.xxx.service.StockService;
import com.stock.xxx.utils.DateUtils;
import com.stock.xxx.utils.StockGrabUtils;
import com.stock.xxx.utils.TaskThread;
import org.apache.log4j.net.SocketServer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {

    @org.junit.Test
    public void test1() throws IOException {
        StockGrabUtils.grab();


    }

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private StockService stockService;

    @Autowired
    private StockHistoryService stockHistoryService;

    @Autowired
    private StockDataService stockDataService;

    @org.junit.Test
    public void test2(){
        StockStock stock = new StockStock();
        stock.setId("6OOO50");
        stock.setName("中国联通");
        stock.setCreatetime(DateUtils.getDate());
        stockService.add(stock);

    }

    @org.junit.Test
    public void test3() throws Exception {
        StockStock stock = stockService.get("600050");
        StockHistory stockHistory = StockGrabUtils.grab(stock);

        stockHistoryService.add(stockHistory);
        System.out.println(stockHistory);
    }


    @org.junit.Test
    public void test4(){
        SearchFilter filter = SearchFilter.buildAndGroup();
        filter.addFilter("code", "600050", SearchConst.EQ);
        Sort sort = new Sort(Sort.Direction.ASC, "date");
        List<StockData> list = stockDataService.getListBySearchFilter(filter, sort);
        System.out.println();
    }


    @org.junit.Test
    public void test5(){


        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sdf.parse("2017-03-21 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(time);

        List<StockHistory> list = stockHistoryService.getListByField("date", time);

        List<StockData> StockDatalist = new ArrayList<StockData>();
        for(StockHistory s: list){
            StockData stockData = new StockData();
            stockData.setStockName(s.getStockname());
            stockData.setClosePrice(String.valueOf(s.getCprice()));
            stockData.setDate(new Timestamp(time.getTime()));
            stockData.setMaxPrice(String.valueOf(s.getHprice()));
            stockData.setMinPrice(String.valueOf(s.getLprice()));
            stockData.setOpenPrice(String.valueOf(s.getKprice()));
            stockData.setTradeNum(String.valueOf(s.getVolume() / 100));
            stockData.setTradeMoney(s.getTotalprice());
            stockData.setCode(s.getCode());
            StockDatalist.add(stockData);
        }

        stockDataService.add(StockDatalist);
    }

    @org.junit.Test
    public void test6(){
        List<StockStock> list = stockService.getList();
        List<StockHistory> list2 = stockHistoryService.getList();

        for(StockStock stock: list){
            String code = stock.getId();
            String name = stock.getName().replace(" ", "");

            for(StockHistory stockHistory: list2){
                String stockname = stockHistory.getStockname().replace(" ", "");
                if(stockname.equals(name)){
                    stockHistory.setCode(code);
                }
            }
        }

        stockHistoryService.update(list2);
    }

    @org.junit.Test
    public void test7(){
        String replace = "c c c a".replace(" ", "");
        System.out.println(replace);
    }

    @org.junit.Test
    public void test8() throws InterruptedException {
        List<StockStock> list = stockService.getListByField("id", "601390");
        if(list.size() > 0){
            final StockStock stock = list.get(0);

            taskExecutor.execute(new TaskThread(60000) {
                @Override
                protected void task() {
                    try {
                        StockHistory stockHistory = StockGrabUtils.grab(stock);
                        System.out.println(stockHistory.getTotalprice());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread.sleep(100000);
        }
    }
}
