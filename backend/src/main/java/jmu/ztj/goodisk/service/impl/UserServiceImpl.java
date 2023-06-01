package jmu.ztj.goodisk.service.impl;

import jmu.ztj.goodisk.entity.account.AccountInfo;
import jmu.ztj.goodisk.mapper.UserMapper;
import jmu.ztj.goodisk.service.UserService;
import jakarta.annotation.Resource;
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
        return mapper.getAllAccountInfo();
    }

    @Override
    public int deleteUser(int id) {
        return mapper.deleteUserById(id);
    }


}
