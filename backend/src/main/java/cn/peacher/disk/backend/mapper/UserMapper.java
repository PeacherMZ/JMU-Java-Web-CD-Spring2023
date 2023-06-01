package cn.peacher.disk.backend.mapper;

import cn.peacher.disk.backend.entity.account.Account;
import cn.peacher.disk.backend.entity.account.AccountInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);
    @Insert("insert into db_account (email,username,password) VALUES(#{email},#{username},#{password})")
    int createAccount(String username,String password,String email);
    @Select("select email, username from db_account where id = #{id}")
    AccountInfo getAccountUsernameAndEmailById(int id);
}
