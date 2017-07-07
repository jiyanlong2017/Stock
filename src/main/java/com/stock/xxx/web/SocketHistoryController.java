package com.stock.xxx.web;

import com.alibaba.fastjson.JSON;
import com.stock.core.jpa.SearchConst;
import com.stock.core.jpa.SearchFilter;
import com.stock.core.utils.HttpUtils;
import com.stock.core.web.JsonResult;
import com.stock.xxx.model.StockData;
import com.stock.xxx.model.StockHistory;
import com.stock.xxx.model.StockStock;
import com.stock.xxx.service.StockDataService;
import com.stock.xxx.service.StockService;
import com.stock.xxx.utils.DateUtils;
import com.stock.xxx.utils.StockGrabUtils;
import com.stock.xxx.utils.TaskThread;
import com.stock.xxx.vo.StockDataVo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JiYanLong on 2017/3/9.
 */
@Controller
@RequestMapping("/stockHistory")
public class SocketHistoryController extends BaseEzCRUDController<StockHistory, Integer> {

    private List<StockStock> allStock = new ArrayList<StockStock>();

    @Autowired
    private StockService stockService;

    @Autowired
    private StockDataService stockDataService;

    @Autowired
    private TaskExecutor taskExecutor;

    @ResponseBody
    @RequestMapping("grabToday")
    public JsonResult grabToday(){

        try{
            if(allStock.size() == 0) {
                allStock = stockService.getList();
            }
            logger.info("开始抓取数据，现在时间" + DateUtils.getDate());
            List<StockHistory> list = new ArrayList<StockHistory>();
            for(StockStock stockStock : allStock) {
                //String id = stockStock.getId();
                try {
                    StockHistory stockHistory = StockGrabUtils.grab(stockStock);
                    list.add(stockHistory);
                } catch (Exception e) {
                    logger.error("股票代码"+ stockStock.getId() + "抓取失败");
                   // e.printStackTrace();
                }
            }

            baseService.add(list);
            return JsonResult.success();
        } catch (Exception ee){
            ee.printStackTrace();
            return JsonResult.error(ee.getMessage());
        }
    }


    public void grabHistory(String startdate, String enddate, List<StockStock> list){
        try{
            List<StockStock> errorList = new ArrayList<StockStock>();
            if(list.size() == 0){
                return;
            }

           for(StockStock stock: list){
               String host = "http://stock.market.alicloudapi.com";
               String path = "/sz-sh-stock-history";
               String method = "GET";
               Map<String, String> headers = new HashMap<String, String>();
               //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
               headers.put("Authorization", "APPCODE 039942641f8b4639a7103d38272f004b");
               Map<String, String> querys = new HashMap<String, String>();
               querys.put("begin", startdate);
               querys.put("code", stock.getId());
               querys.put("end", enddate);
               try {
                   /**
                    * 重要提示如下:
                    * HttpUtils请从
                    * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                    * 下载
                    *
                    * 相应的依赖请参照
                    * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                    */
                   HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);

                   if(httpResponse.getStatusLine().getStatusCode() == 200){

                       HttpEntity entity = httpResponse.getEntity();
                       String result = EntityUtils.toString(entity);
                       StockDataVo json = JSON.parseObject(result, StockDataVo.class);
                       //System.out.print(json);

                       //StockData stockData = new StockData();
                       StockDataVo.Showapi_res_body showapi_res_body = json.getShowapi_res_body();
                       List<StockDataVo.Showapi_res_body.StockHistoryVo> voList = showapi_res_body.getList();
                       List<StockData> stockDataList = new ArrayList<StockData>();
                       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                       for(StockDataVo.Showapi_res_body.StockHistoryVo vo: voList){
                           StockData stockData = new StockData();
                           stockData.setClosePrice(vo.getClose_price());
                           stockData.setCode(vo.getCode());
                           long time = simpleDateFormat.parse(vo.getDate()).getTime();
                           Timestamp timestamp = new Timestamp(time);
                           stockData.setDate(timestamp);
                           stockData.setDiffMoney(vo.getDiff_money());
                           stockData.setDiffRate(vo.getDiff_rate());
                           stockData.setMarket(vo.getMarket());
                           stockData.setMaxPrice(vo.getMax_price());
                           stockData.setMinPrice(vo.getMin_price());
                           stockData.setOpenPrice(vo.getOpen_price());
                           stockData.setStockName(vo.getStockName());
                           stockData.setSwing(vo.getSwing());
                           stockData.setTradeMoney(vo.getTrade_money());
                           stockData.setTradeNum(vo.getTrade_num());
                           stockData.setTurnover(vo.getTurnover());
                           stockDataList.add(stockData);
                       }

                       stockDataService.add(stockDataList);
                       //return stockDataList;
                       logger.info("股票代码"+ stock.getId() + stock.getName() + "抓取成功");


                   } else {
                       errorList.add(stock);
                       logger.info(startdate + enddate + "股票代码"+ stock.getId() + stock.getName() + "响应失败");
                       logger.info(Thread.currentThread().getId() + "线程 抓取失败, 休息10秒");
                       Thread.sleep(10000);
                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   errorList.add(stock);
                   logger.error("股票代码"+ stock.getId() +  stock.getName() + "抓取失败");
               }

           }

            grabHistory(startdate, enddate, errorList);
            logger.error(startdate + "----" + enddate + "数据抓取成功");

            // return JsonResult.success();
        } catch (Exception ee){
            ee.printStackTrace();
           // return JsonResult.error("");
        }
    }


    @RequestMapping("history")
    @ResponseBody
    public JsonResult dxcGrab(){

        try{
            if(allStock.size() == 0) {
                allStock = stockService.getList();
            }
            Calendar calendar = Calendar.getInstance();
            List<Thread> threadList = new ArrayList<Thread>();
            for(int i = 0; i < 12; i++){
                SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
                final String enddate = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE, -31);
                final String startdate = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE, -1);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        System.out.println("threadId:" + this.getId());
                        System.out.println("结束时间：" + enddate + "开始时间：" + startdate);
                        //
                        grabHistory(startdate, enddate, allStock);

                    }
                };
                threadList.add(thread);
            }

            for(Thread thread: threadList){
                thread.start();
            }
            return JsonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("");
        }
    }

    /**
     * 抓取成交额 每分钟一次
     * @return
     */
    @RequestMapping("grabTotalMoney")
    @ResponseBody
    public JsonResult grabTotalMoney(@RequestParam String id){
        try{

            List<StockStock> list = stockService.getListByField("id", id);
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
            }


            return JsonResult.success();
        } catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage() + "循环抓取成交额失败");
            return JsonResult.error(e.getMessage());
        }
    }
}
