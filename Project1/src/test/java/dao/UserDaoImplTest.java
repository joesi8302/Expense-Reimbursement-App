package dao;

import models.UserLoginModel;
import models.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ReimbUtil;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    ReimbDao reimbDao;
    ReimbTypeDao reimbTypeDao;
    ReimbStatusDao reimbStatusDao;
    UserDao userDao;
    UserRoleDao userRoleDao;

    public UserDaoImplTest(){
        this.reimbDao = new ReimbDaoImpl(ReimbUtil.url, ReimbUtil.username, ReimbUtil.password);
        this.reimbStatusDao = new ReimbStatusDaoImpl(ReimbUtil.url, ReimbUtil.username, ReimbUtil.password);
        this.reimbTypeDao = new ReimbTypeDaoImpl(ReimbUtil.url, ReimbUtil.username, ReimbUtil.password);

        this.userDao = new UserDaoImpl(ReimbUtil.url, ReimbUtil.username, ReimbUtil.password);
        this.userRoleDao = new UserRoleDaoImpl(ReimbUtil.url, ReimbUtil.username, ReimbUtil.password);

    }

    @BeforeEach
    void setUp() {

        ReimbUtil.createReimbStatusTable();
        ReimbUtil.createReimbTypeTable();
        ReimbUtil.createUserRolesTable();

        ReimbUtil.createUsersTable();
        ReimbUtil.createReimbTable();

    }

    @AfterEach
    void tearDown() {

        ReimbUtil.dropReimbTable();
        ReimbUtil.dropUsersTable();

        ReimbUtil.dropReimbStatusTable();
        ReimbUtil.dropReimbTypeTable();
        ReimbUtil.dropUserRolesTable();
    }

    @Test
    void userLogin() {

        userRoleDao.createUserRole("Employee");

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);



        UserModel actualResult = userDao.userLogin(new UserLoginModel("joesi", "password"));

        assertEquals(user, actualResult);


    }

    @Test
    void createUser() {

        userRoleDao.createUserRole("Employee");

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);



        UserModel actualResult = userDao.userLogin(new UserLoginModel("joesi", "password"));

        assertEquals(user, actualResult);

    }

    @Test
    void deleteUser() {
    }
}