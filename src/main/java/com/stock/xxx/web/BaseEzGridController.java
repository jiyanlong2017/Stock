package com.stock.xxx.web;

import com.stock.xxx.model.BaseModel;

import java.util.UUID;

/**
 * 基于EasyUI Grid的CRUD控制器
 */
public class BaseEzGridController<T extends BaseModel<String>> extends BaseCRUDController<T, String> {

  /*  *//**
     * 获取EasyUI Grid数据的接口
     * 返回页面上Grid所需要的列表数据(根路径以/test/ajaxgrid为例)
     * URL: /test/ajaxgrid/list GET
     *//*
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(EzPage ezPage, HttpServletRequest request) {
        //构建一个分页请求对象
        Pageable pageRequest = ezPage.buildJPAPageRequest();

        Map<String, String[]> params = Servlets.getSearchParameters(request);
        SearchFilter group = SearchFilter.parse(params);

        try {
            //获取分页结果
            Page<T> pageResult;

            //是否需要根据权限进行数据过滤
            if (isNeedToFilterGrid) {
                group.setMenuKey(menuKey);
                pageResult = baseService.getListByPageWithPermission(pageRequest, group);
            } else {
                pageResult = baseService.getListByPage(pageRequest, group);
            }

            //是否需要进行视图对象转换
            if (isNeedToConvertVO) {
                List<Object> list = new ArrayList<Object>();
                for (T t : pageResult.getContent()) {
                    Object vo = convertVO(t);
                    list.add(vo);
                }

                return EzPageResult.build(pageResult.getTotalElements(), list);
            }

            return EzPageResult.build(pageResult);
        } catch (Exception ex) {
            logger.error("获取数据失败", ex);
            return EzPageResult.build(0, new ArrayList<T>());
        }
    }*/


    @Override
    protected Object convertVO(T t) {
        return t;
    }

    @Override
    protected String getNewID() {
        return UUID.randomUUID().toString();
    }
}
