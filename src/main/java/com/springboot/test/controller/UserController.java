package com.springboot.test.controller;

import com.springboot.test.pojo.User;
import com.springboot.test.result.JsonResult;
import com.springboot.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JCH
 * @date 2021/03/09 上午 09:53
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping("/addUser")
    public String add(@RequestBody User user) throws Exception{
        if(null != user){
            userService.insertUser(user);
            return "success";
        }else {
            return "false";
        }
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }


//    @GetMapping("/user")
//    public User getUser(HttpServletRequest request) {
//        ServletContext application = request.getServletContext();
//        return (User) application.getAttribute("user");
//    }

//    @RequestMapping("/user")
//    public JsonResult<User> users(){
//        User user = new User(1,"123","123");
//        return new JsonResult<>(user);
//    }
//
//    @RequestMapping("/list")
//    public JsonResult<List> list(){
//       List<User> list = new ArrayList<User>();
//       User user1 = new User(2,"456","123");
//       User user2 = new User(2,"456","123");
//       list.add(user1);
//       list.add(user2);
//       return new JsonResult<>(list,"成功");
//    }
//
//    @RequestMapping("/map")
//    public JsonResult<Map> getMap() {
//        Map<String, Object> map = new HashMap<>();
//        User user = new User(1, "倪升武","123");
//        map.put("作者信息", user);
//        map.put("博客地址", "http://blog.itcodai.com");
//        map.put("CSDN地址", null);
//        map.put("粉丝数量", 4153);
//        return new JsonResult<>(map);
//    }
////    @RequestMapping("/log")
////    public String log(){
////        logger.debug("================debug===============");
////        logger.info("================info===============");
////        logger.error("================error===============");
////        logger.warn("================warn===============");
////        return "success";
////    }
//    @GetMapping("/aop/{name}")
//    public String aop(@PathVariable String name){
//        return "hello word" + name;
//    }

}

