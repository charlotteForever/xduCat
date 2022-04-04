package com.web.xducatserver.controller;

import com.web.xducatserver.Entity.User;
import com.web.xducatserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    UserRepository userRepository;


    //用户登录，第一个参数是用户名，第二个是密码。类似于
    //http://localhost:8888/user/login/super/123

    @RequestMapping(value="/login/{username}/{password}")
    public boolean login(@PathVariable("username") String username, @PathVariable("password") String password){

        try{
            User res=userRepository.getById(username);
            String truePassword=res.getPassword();
            if(truePassword.equals(password)==false){System.out.println("密码错误！");return false;}
            return true;
        }
        catch (Exception e)
        {
            System.out.println("用户不存在！");
            return false;
        }
    }

}
