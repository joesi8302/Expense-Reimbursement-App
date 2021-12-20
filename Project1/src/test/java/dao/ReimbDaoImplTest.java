package dao;

import models.ReimbModel;
import models.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ReimbUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbDaoImplTest {

    ReimbDao reimbDao;
    ReimbTypeDao reimbTypeDao;
    ReimbStatusDao reimbStatusDao;
    UserDao userDao;
    UserRoleDao userRoleDao;


    public ReimbDaoImplTest(){
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
    void getAllReimb() {
        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        List<ReimbModel> actualResult = reimbDao.getAllReimb();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getAllReimbUser() {
        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        List<ReimbModel> actualResult = reimbDao.getAllReimbUser(1);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getOneReimb() {
        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        //date = reimbDao.getOneReimb(1).getReimb_submitted();
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));


        List<ReimbModel> actualResult = reimbDao.getAllReimbUser(1);

        assertEquals(expectedResult.get(0),actualResult.get(0));
    }

    @Test
    void createReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        List<ReimbModel> actualResult = reimbDao.getAllReimb();

        assertEquals(expectedResult.size(),actualResult.size());



    }

    @Test
    void approveReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        userRoleDao.createUserRole("Manager");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");
        reimbStatusDao.createReimbStatus("Pending");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        UserModel user2 = new UserModel(2, "kevchilds", "password", "Kevin", "Si", "1@gmail", 2);
        userDao.createUser(user2);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        reimbDao.approveReimb(2, 1);

        ReimbModel wantedResult = reimbDao.getOneReimb(1);
        ReimbModel actualResult = reimbDao.getOneReimb(1);


        assertEquals(wantedResult,actualResult);
    }

    @Test
    void denyReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        userRoleDao.createUserRole("Manager");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");
        reimbStatusDao.createReimbStatus("Approved");
        reimbStatusDao.createReimbStatus("Denied");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        UserModel user2 = new UserModel(2, "kevchilds", "password", "Kevin", "Si", "1@gmail", 2);
        userDao.createUser(user2);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        reimbDao.denyReimb(2,1);

        ReimbModel wantedResult = reimbDao.getOneReimb(1);
        ReimbModel actualResult = reimbDao.getOneReimb(1);

        assertEquals(wantedResult,actualResult);
    }

    @Test
    void deleteReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        userRoleDao.createUserRole("Employee");
        reimbTypeDao.createReimbType("Business");
        reimbStatusDao.createReimbStatus("Pending");

        //Timestamp date = new Timestamp(System.currentTimeMillis());

        Timestamp date = null;

        UserModel user = new UserModel(1, "joesi", "password", "Joe", "Si", "@gmail", 1);
        userDao.createUser(user);
        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, 0, 1, 1));
        reimbDao.createReimb(expectedResult.get(0));
        reimbDao.createReimb(expectedResult.get(1));
        reimbDao.createReimb(expectedResult.get(2));

        List<ReimbModel> actualResult = reimbDao.getAllReimbUser(1);

        assertEquals(expectedResult.get(0),actualResult.get(0));
    }
}