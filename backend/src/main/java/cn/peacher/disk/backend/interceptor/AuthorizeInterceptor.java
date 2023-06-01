package cn.peacher.disk.backend.interceptor;

import cn.peacher.disk.backend.entity.account.AccountInfo;
import cn.peacher.disk.backend.mapper.UserMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {
    @Resource
    UserMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
//        System.out.println(authentication.getPrincipal());
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
//        System.out.println(username);
        AccountInfo account = mapper.getAccountInfoByNameOrEmail(username);
//        System.out.println(accountInfo.getId()+accountInfo.getEmail());
        request.getSession().setAttribute("account",account);
        return true;
    }
}
