package cn.labelpub.controller;

import cn.labelpub.entity.account.AccountInfo;
import cn.labelpub.entity.RestBean;
import cn.labelpub.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
public class UserController {
    @Resource
    UserService service;
    @PostMapping("/getUserInfo")
    public RestBean<String> getUsernameAndEmail(@RequestParam("id") int id,HttpSession session){
        String res = JSON.toJSONString(service.loadUsernameAndEmail(id, session.getId()),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
        if(res == null){
            return RestBean.failure(400,"发生了错误");
        } else {
            return RestBean.success(res);
        }
    }

    @PostMapping("/edit")
    public RestBean<String> editUserInfo(@RequestParam("id") int id,
                                         @RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         @RequestParam("email") String email,
                                         HttpSession session){
        int res = service.editUserInfo(id,username,password,email);
        if(res > 0){
            return RestBean.success("编辑用户数据成功");
        } else {
            return RestBean.failure(400,"发生了错误，请联系管理员");
        }
    }
    @PostMapping("/getAllUsers")
    public RestBean<String> getAllAccountInfo(HttpSession session){
        String res = JSON.toJSONString(service.loadAllUserInfo(session.getId()),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
        if(res == null){
            return RestBean.failure(400,"发生了错误");
        } else {
            return RestBean.success(res);
        }
    }

    @GetMapping("/me")
    public RestBean<AccountInfo> getMyInfo(@SessionAttribute("account") AccountInfo account,
                                           HttpSession session){
        return RestBean.success(account);
    }

    @PostMapping("/deleteUser")
    public RestBean<String> deleteUserById(int id, HttpSession session){
        int res = service.deleteUser(id);
        if(res > 0){
            return RestBean.success("删除成功");
        } else {
            return RestBean.failure(400,"删除失败");
        }
    }
}
