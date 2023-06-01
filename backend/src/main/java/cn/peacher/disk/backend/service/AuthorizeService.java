package cn.peacher.disk.backend.service;

import cn.peacher.disk.backend.entity.account.AccountInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    String validateAndRegister(String username, String password, String email, String session);
}
