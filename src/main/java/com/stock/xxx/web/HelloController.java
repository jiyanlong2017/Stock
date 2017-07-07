package com.stock.xxx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/7.
 */
@RequestMapping("/hello")
@Controller
public class HelloController extends BaseController {

    @RequestMapping()
    public String index(){
        return "test/index";
    }
}
