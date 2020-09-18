package com.yangl.shardingsphere.api.controller;

import com.yangl.shardingsphere.domain.entity.InvTransaction;
import com.yangl.shardingsphere.domain.entity.User;
import com.yangl.shardingsphere.domain.service.InvTransactionService;
import com.yangl.shardingsphere.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author li.yang01@hand-china.com 2020/9/9 1:07 下午
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("save-user")
    public Object insertInv() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            User user = new User((long)i,"goudan","man",i*10);
            userService.save(user);
        }
        return "success";
    }

    @GetMapping("query-user")
    public List<User> queryInv() {
        List<User> list = userService.list();
        return list;
    }



}
