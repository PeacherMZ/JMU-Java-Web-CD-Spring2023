package cn.peacher.disk.backend.controller;

import cn.peacher.disk.backend.entity.RestBean;
import cn.peacher.disk.backend.service.UserService;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/user")
public class UserController {
    @Resource
    UserService service;
    @PostMapping("/info")
    public RestBean<String> getUsernameAndEmail(@RequestParam("id") int id,HttpSession session){
        String res = JSONObject.toJSONString(service.loadUsernameAndEmail(id, session.getId()));
        if(res == null){
            return RestBean.success(res);
        } else {
            return RestBean.failure(400,res);
        }
    }
}
