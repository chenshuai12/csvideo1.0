//package com.csvideo.manager.controller;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by asus on 2019/3/19.
// */
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//    @RequestMapping("/name")
//    public Map name(){
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        Map map = new HashMap<>();
//        map.put("loginName",name);
//        return map;
//    }
//}
