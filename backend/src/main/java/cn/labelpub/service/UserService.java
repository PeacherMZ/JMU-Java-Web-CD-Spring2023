package cn.labelpub.service;

import cn.labelpub.entity.account.AccountInfo;

public interface UserService {
    AccountInfo loadUsernameAndEmail(int id, String session);
    int editUserInfo(int id, String username, String password, String email);
    AccountInfo[] loadAllUserInfo(String session);

    int deleteUser(int id);
}
