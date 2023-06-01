package cn.peacher.disk.backend.service;

import cn.peacher.disk.backend.entity.account.AccountInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AccountInfo loadUsernameAndEmail(int id, String session);
}
