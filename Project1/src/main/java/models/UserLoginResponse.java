package models;

public class UserLoginResponse {
    private String ers_username;
    private Integer ers_user_id;
    private Integer user_role_id;

    public UserLoginResponse(){}

    public UserLoginResponse(String ers_username, Integer ers_user_id, Integer user_role_id) {
        this.ers_username = ers_username;
        this.ers_user_id = ers_user_id;
        this.user_role_id = user_role_id;
    }

    public String getUsername() {
        return ers_username;
    }

    public void setUsername(String ers_username) {
        this.ers_username = ers_username;
    }

    public Integer getErs_user_id() {
        return ers_user_id;
    }

    public void setErs_user_id(Integer ers_user_id) {
        this.ers_user_id = ers_user_id;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }


    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "ers_username='" + ers_username + '\'' +
                ", ers_user_id=" + ers_user_id +
                ", user_role_id=" + user_role_id +
                '}';
    }
}
