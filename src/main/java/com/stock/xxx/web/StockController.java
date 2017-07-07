package com.stock.xxx.web;

import com.stock.core.jpa.SearchConst;
import com.stock.core.jpa.SearchFilter;
import com.stock.core.web.JsonResult;
import com.stock.xxx.model.StockData;
import com.stock.xxx.model.StockStock;
import com.stock.xxx.service.StockDataService;
import com.stock.xxx.service.StockService;
import com.stock.xxx.utils.DateUtils;
import com.stock.xxx.utils.StockGrabUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by JiYanLong on 2017/3/8.
 */
@Controller
@RequestMapping("/stock")
@Scope
public class StockController extends BaseEzCRUDController<StockStock, String> {

    private static final Object lock = new Object();

    private static boolean canGrab = false;

    @Autowired
    private StockService stockService;

    @Autowired
    private StockDataService stockDataService;

    @RequestMapping("index")
    public String index(){
        return "stock/index";
    }

    @RequestMapping("grabtodaty")
    public String grabtodaty(){
        return "stock/grab";
    }

    @RequestMapping(value = "searchStock", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult searchStock(@RequestParam String key){
        try{
            SearchFilter filter = SearchFilter.buildOrGroup();
            filter.addFilter("code", key, SearchConst.EQ);
            filter.addFilter("stockName", key, SearchConst.EQ);
            Sort sort = new Sort(Sort.Direction.ASC, "date");
            List<StockData> list = stockDataService.getListBySearchFilter(filter, sort);

            return JsonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(e.getMessage());
        }



    }





    @RequestMapping("grab")
    @ResponseBody
    public JsonResult grab() {

        try {
            synchronized (lock) {
                Map<String, String> map = StockGrabUtils.grab();

                Set<String> set = map.keySet();
                List<StockStock> list = new ArrayList<StockStock>();
                for(String key: set){
                    StockStock stock = new StockStock();
                    String name = map.get(key);
                    stock.setId(key);
                    stock.setName(name);
                    stock.setCreatetime(DateUtils.getDate());
                    list.add(stock);
                }

                return JsonResult.success();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonResult.error("");
        }
    }
}
