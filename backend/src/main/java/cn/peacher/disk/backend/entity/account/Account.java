package cn.peacher.disk.backend.entity.account;

import lombok.Data;

@Data
public class Account {
    int id;
    String email;
    String username;
    String password;

}
