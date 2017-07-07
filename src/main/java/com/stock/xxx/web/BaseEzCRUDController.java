package com.stock.xxx.web;

import com.stock.xxx.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/9.
 */
public class BaseEzCRUDController<T extends BaseModel<ID>, ID extends Serializable> extends BaseCRUDController<T, ID> {

    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(ServletRequest request){
        try{
            Pageable queryParams = getQueryParams(request);
            Page<T> page = baseService.getListByPage(queryParams);
            return bulidPageResult(page);
        } catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return bulidPageResultError();
        }
        
    }

    private Map<String, Object> bulidPageResultError() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        return map;
    }

    private Map<String, Object> bulidPageResult(Page<T> page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotalElements());
        map.put("rows", page.getContent());
        return map;
    }

    @Override
    protected Object convertVO(T t) {
        return null;
    }

    @Override
    protected ID getNewID() {
        return (ID) UUID.randomUUID().toString();
    }

    private  Pageable getQueryParams(final ServletRequest request){

        final Map<String, String[]> map = request.getParameterMap();
        Sort.Direction direction =  map.get("order")[0].equalsIgnoreCase("asc")? Sort.Direction.ASC : Sort.Direction.DESC;
        String orderName = map.get("sort")[0];
        Sort sort = new Sort(direction, orderName);
        return new PageRequest(Integer.parseInt(map.get("page")[0]) -1, Integer.parseInt(map.get("rows")[0]), sort);
    }
}
