package com.ctgu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义一个控制器,其功能相当于servlet
 */
public class HelloSpringMvc implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView view = new ModelAndView();
//        这就相当于request.setattribute(),也就是给东西赋值嘛
        view.addObject("hello", "hello my first  springmvc project");
//        设置jsp相对于项目中的路径,也就是我们跳转的时候跳转到哪个jsp文件中去
        view.setViewName("/WEB-INF/jsp/first.jsp");

        return view;
    }
}
