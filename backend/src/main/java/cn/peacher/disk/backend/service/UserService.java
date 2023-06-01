package cn.peacher.disk.backend.service;

import cn.peacher.disk.backend.entity.account.AccountInfo;

public interface UserService {
    AccountInfo loadUsernameAndEmail(int id, String session);
    int editUserInfo(int id, String username, String password, String email);
    AccountInfo[] loadAllUserInfo();
}
