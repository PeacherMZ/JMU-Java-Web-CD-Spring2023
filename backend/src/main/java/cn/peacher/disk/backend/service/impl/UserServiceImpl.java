package cn.peacher.disk.backend.service.impl;

import cn.peacher.disk.backend.entity.account.Account;
import cn.peacher.disk.backend.entity.account.AccountInfo;
import cn.peacher.disk.backend.mapper.UserMapper;
import cn.peacher.disk.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public AccountInfo loadUsernameAndEmail(int id, String session) {
        AccountInfo accountInfo = mapper.getAccountUsernameAndEmailById(id);
        if(accountInfo == null) throw new UsernameNotFoundException("ID为 "+id+" 的用户不存在");
        return accountInfo;
    }

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
}
