package me.ye.javaeedemo.dao;

import me.ye.javaeedemo.entity.Account;

/**
 * Created by Jacob on 1/2/2018.
 */

public interface AccountDAO {

    Account findById(String id);

}
