package dao;

import models.UserLoginModel;
import models.UserModel;

public interface UserDao {

    UserModel userLogin(UserLoginModel user);
    void createUser(UserModel user);
    void deleteUser(Integer ers_user_id);

}
