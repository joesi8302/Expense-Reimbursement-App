package services;

import dao.UserDao;
import dao.UserDaoImpl;
import models.UserLoginModel;
import models.UserModel;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class UserDaoService {

    UserDao userDao;

    public UserDaoService(UserDao userDao){this.userDao = userDao;}

    public UserDaoService(){this.userDao = new UserDaoImpl();}

    public UserModel userLogin(UserLoginModel user){
        UserModel checkUser = userDao.userLogin(user);
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

        boolean passCheck = passwordEncryptor.checkPassword(user.getPassword(), checkUser.getErs_password());

        if(checkUser == null){
            return null;
        }
        else{
            if(passCheck){
                return checkUser;
            }
        }

        return null;
    }
    public void createUser(UserModel user){
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String enncryptedPassword = passwordEncryptor.encryptPassword(user.getErs_password());
        UserModel newUser = new UserModel(user.getErs_username(), enncryptedPassword, user.getUser_first_name(), user.getUser_last_name()
                , user.getUser_email(), user.getUser_role_id());

        userDao.createUser(newUser);}
    public void deleteUser(Integer ers_user_id){}


}
