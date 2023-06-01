package jmu.ztj.goodisk.controller;

import jmu.ztj.goodisk.entity.RestBean;
import jmu.ztj.goodisk.service.AuthorizeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/auth")
public class AuthorizeController {
    @Resource
    AuthorizeService service;
    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@RequestParam("email") String email){
        return RestBean.success("前面的区域，以后再来探索吧！");
    }

    @PostMapping("/register")
    public RestBean<String> registerUser(@RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         @RequestParam("email") String email,
                                         HttpSession session){

        String res = service.validateAndRegister(username, password, email, session.getId());
        if(res == null){
            return RestBean.success("注册成功！");
        } else {
            return RestBean.failure(400,res);
        }
    }
}
