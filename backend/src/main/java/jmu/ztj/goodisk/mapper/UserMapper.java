package jmu.ztj.goodisk.mapper;

import jmu.ztj.goodisk.entity.account.Account;
import jmu.ztj.goodisk.entity.account.AccountInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from db_account where username = #{text} or email = #{text}")
    AccountInfo getAccountInfoByNameOrEmail(String text);
    @Insert("insert into db_account (email,username,password) VALUES(#{email},#{username},#{password})")
    int createAccount(String username,String password,String email);
    @Select("select email, username from db_account where id = #{id}")
    AccountInfo getAccountUsernameAndEmailById(int id);

    @Update("update db_account set username=#{username}, email=#{email}, password=#{password} where id=#{id}")
    int editUserInfoWithPwd(int id, String username, String password, String email);

    @Update("update db_account set username=#{username}, email=#{email} where id=#{id}")
    int editUserInfoWithoutPwd(int id, String username, String email);
    @Select("select id, username, email from db_account ")
    AccountInfo[] getAllAccountInfo();

    @Delete("delete from db_account where id=#{id}")
    int deleteUserById(int id);
}
