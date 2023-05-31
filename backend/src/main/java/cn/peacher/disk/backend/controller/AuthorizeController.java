package cn.peacher.disk.backend.controller;

import cn.peacher.disk.backend.entity.RestBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthorizeController {
    @PostMapping("")
    public RestBean<String> validateEmail(@RequestParam("email") String email){
        return RestBean.success("前面的路，以后再来探索吧！");
    }
}
