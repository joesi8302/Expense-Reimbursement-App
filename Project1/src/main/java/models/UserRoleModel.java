package models;

import java.util.Objects;

public class UserRoleModel {

    private Integer ers_user_role_id;
    private String user_role;

    public UserRoleModel(){}

    public UserRoleModel(Integer ers_user_role_id, String user_role) {
        this.ers_user_role_id = ers_user_role_id;
        this.user_role = user_role;
    }

    public Integer getErs_user_role_id() {
        return ers_user_role_id;
    }

    public void setErs_user_role_id(Integer ers_user_role_id) {
        this.ers_user_role_id = ers_user_role_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleModel that = (UserRoleModel) o;
        return Objects.equals(ers_user_role_id, that.ers_user_role_id) && Objects.equals(user_role, that.user_role);
    }

    @Override
    public String toString() {
        return "UserRoleModel{" +
                "ers_user_role_id=" + ers_user_role_id +
                ", user_role='" + user_role + '\'' +
                '}';
    }

}
