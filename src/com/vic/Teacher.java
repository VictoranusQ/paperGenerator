package com.vic;

public class Teacher {
    private String username;
    private String password;
    private int stage;//阶段标识符，8848：小学 8849：初中 8850：高中

    public int getStage() {
        return stage;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
