package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Account;

public interface AccountDAO {

    // 查询是否重名（？）
    Account getAccountByUsername(String username);

    //登录的方法
    Account getAccountByUsernameAndPassword(Account account);

    // 注册，插入新用户到数据库
    void insertAccount(Account account);

    //插入简介(?)
    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);
}
