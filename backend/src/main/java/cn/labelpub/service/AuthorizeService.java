package cn.labelpub.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    String validateAndRegister(String username, String password, String email, String session);
}
