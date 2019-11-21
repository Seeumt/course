package cn.ec.pojo;

import io.swagger.models.auth.In;

public class User {

    private String username;
    private Integer gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public User(String username, Integer gender) {
        this.username = username;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", gender=" + gender +
                '}';
    }
}
