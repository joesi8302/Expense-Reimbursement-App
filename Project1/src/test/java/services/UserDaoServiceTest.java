package services;

import dao.UserDao;
import models.ReimbModel;
import models.UserLoginModel;
import models.UserModel;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoServiceTest {

    UserDao userDao = Mockito.mock(UserDao.class);

    UserDaoService userDaoService;

    public UserDaoServiceTest() {this.userDaoService = new UserDaoService(userDao);}

    @Test
    void userLogin() {

        UserModel user = new UserModel(1, "joesi", "elXGUP2Csk86+6EcqmrYbd1roRoOTmLF", "Joe", "Si", "@gmail", 1);

        UserLoginModel user1 = new UserLoginModel("joesi", "password");

        Mockito.when(userDao.userLogin(user1)).thenReturn(user);

        UserModel expectedResult = user;

        UserModel actualResult = userDaoService.userLogin(user1);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void userLoginFail() {

        UserModel user = new UserModel(1, "joesi", "elXGUP2Csk86+6EcqmrYbd1roRoOTmLF", "Joe", "Si", "@gmail", 1);

        UserLoginModel user1 = new UserLoginModel("joesi", "passwor");

        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

        Mockito.when(userDao.userLogin(user1)).thenReturn(user);

        UserModel expectedResult = null;

        UserModel actualResult = userDaoService.userLogin(user1);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void createUser() {

        UserModel userToTest = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);

        userDao.createUser(userToTest);

        Mockito.verify(userDao, Mockito.times(1)).createUser(userToTest);

    }

    @Test
    void deleteUser() {
    }
}