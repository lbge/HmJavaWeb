package com.xducs.domain;

/**
 * @author Linbo Ge
 * @date 2020/3/21 - 15:59
 */
public class User {
    private int id;
    private String username;
    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
