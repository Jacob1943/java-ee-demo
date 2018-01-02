package me.ye.javaeedemo.entity;

import me.ye.javaeedemo.annotation.Entity;

/**
 * Created by Jacob on 1/2/2018.
 */


@Entity("account")
public class Account {

    private String id;
    private String role;
    private Long roleId;
    private String password;
    private String salt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
