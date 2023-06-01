package cn.peacher.disk.backend.service.impl;

import cn.peacher.disk.backend.entity.account.Account;
import cn.peacher.disk.backend.entity.account.AccountInfo;
import cn.peacher.disk.backend.mapper.UserMapper;
import cn.peacher.disk.backend.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
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
    public int editUserInfo(int id, String username, String password, String email) {
        int res = 0;
        if(password.equals("")){
            res = mapper.editUserInfoWithoutPwd(id,username,email);
        } else {
            password = encoder.encode(password);
            res = mapper.editUserInfoWithPwd(id,username,password,email);
        }
        return res;
    }

    @Override
    public AccountInfo[] loadAllUserInfo(String session) {
        AccountInfo[] accountInfos = mapper.getAllAccountInfo();

        return accountInfos;
    }


}
