package com.example.YukawaChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.YukawaChat.entity.USERS;
import com.example.YukawaChat.service.USERS_Service;;

@Controller
public class USERS_Controller {

    @Autowired
    USERS_Service usersService;

    /**
     * メイン画面
     * @param model
     * @return
     */
    @GetMapping("/")
    private String hosii_main(Model model){
        return "hosii_main";
    }

    /**
     * 全ユーザー表示
     * @param model
     * @return showUsers.html
     */
    @GetMapping("users")
    private String getUSERS(Model model){
        List<USERS> list = usersService.getUser();
        model.addAttribute("list",list);
        return "showUsers";
    }

    @PostMapping("users")
    private String getUSERSserch(@RequestParam(name = "name") String name, Model model){
        List<USERS> list = usersService.serchName(name);
        model.addAttribute("list",list);
        return "showUsers";
    }

    /**
     * ユーザー登録画面に遷移
     * @param model
     * @return NewUser.html
     */
    @RequestMapping("NewUser")
    String NewUser(Model model){
        USERS user = new USERS();
        model.addAttribute("user",user);
        return "NewUser";
    }

    /**
     * ユーザー登録
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("createUser")
    public String createUser(Model model, USERS user){
        System.out.println("aaa");
        usersService.createUser(user);
        List<USERS> list = usersService.getUser();
        model.addAttribute("list",list);
        return "showUsers";
    }
}
