package models;

import java.util.Objects;

public class UserModel {

    private Integer ers_user_id;
    private String ers_username;
    private String ers_password;
    private String user_first_name;
    private String user_last_name;
    private String user_email;
    private Integer user_role_id;


    public UserModel(){}

    public UserModel(String ers_username, String ers_password, String user_first_name, String user_last_name, String user_email, Integer user_role_id) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
        this.user_role_id = user_role_id;
    }

    public UserModel(Integer ers_user_id, String ers_username, String ers_password, String user_first_name, String user_last_name, String user_email, Integer user_role_id) {
        this.ers_user_id = ers_user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
        this.user_role_id = user_role_id;
    }

    public Integer getErs_user_id() {
        return ers_user_id;
    }

    public void setErs_user_id(Integer ers_user_id) {
        this.ers_user_id = ers_user_id;
    }

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(ers_user_id, userModel.ers_user_id) && Objects.equals(ers_username, userModel.ers_username) && Objects.equals(ers_password, userModel.ers_password) && Objects.equals(user_first_name, userModel.user_first_name) && Objects.equals(user_last_name, userModel.user_last_name) && Objects.equals(user_email, userModel.user_email) && Objects.equals(user_role_id, userModel.user_role_id);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ers_user_id=" + ers_user_id +
                ", ers_username='" + ers_username + '\'' +
                ", ers_password='" + ers_password + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_role_id=" + user_role_id +
                '}';
    }
}




