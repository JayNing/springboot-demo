package com.ning.springbootdemo.controller;

import com.ning.springbootdemo.cache.UserCache;
import com.ning.springbootdemo.entity.User;
import com.ning.springbootdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用@RestController后，此controller中的接口返回全为json字符串，@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 * 使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面。若返回json等内容到页面，则需要加@ResponseBody注解
 * @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，
 * 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 * */
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private UserCache userCache;

    @RequestMapping("/hello")
    public void  hello(HttpServletResponse response) throws IOException {
        logger.info("test demo");
        //springBoot 后台方法进行重定向到某个页面
        response.sendRedirect("/static/hello.html");
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("age") Integer age) {

        User user = new User();
        user.setAge(age);
        user.setUsername(name);
        request.getSession().setAttribute("user",user);
        return "user login success";
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        User user = new User();
        user.setAge(age);
        user.setUsername(name);
        userService.insertUser(user);
        return "user add success";
    }

    @RequestMapping("/searchById")
    @ResponseBody
    public User searchById(@RequestParam("id") Integer id) {
        User user = userService.searchById(id);
        return user;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(String username) throws Exception {
        logger.info("username : " + username);
//        throw new RuntimeException("不能为空");
//        throw UserException.TEST.newInstance("%s 是好样的", "张三");
        return userCache.getUser(username);
    }
}