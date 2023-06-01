package cn.peacher.disk.backend.service.impl;

import cn.peacher.disk.backend.entity.account.Account;
import cn.peacher.disk.backend.entity.account.AccountInfo;
import cn.peacher.disk.backend.mapper.UserMapper;
import cn.peacher.disk.backend.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    @Resource
    UserMapper mapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null)
            throw new UsernameNotFoundException("用户名不能为空");
        Account account = mapper.findAccountByNameOrEmail(username);
        if(account == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("user")
                .build();
    }

    @Override
    public String validateAndRegister(String username, String password, String email, String sessionId) {
        password = encoder.encode(password);
        if (mapper.createAccount(username, password, email) > 0) {
            return null;
        } else {
            return "内部错误，请联系管理员";
        }
    }



}
