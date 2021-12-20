package services;

import dao.ReimbDao;
import models.ReimbModel;
import models.ResolveReimbModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbDaoServiceTest {

    ReimbDao reimbDao = Mockito.mock(ReimbDao.class);

    ReimbDaoService reimbDaoService;

    public ReimbDaoServiceTest() {this.reimbDaoService = new ReimbDaoService(reimbDao);}

    @Test
    void getAllReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        Mockito.when(reimbDao.getAllReimb()).thenReturn(expectedResult);

        List<ReimbModel> actualResult = reimbDao.getAllReimb();

        assertEquals(expectedResult,actualResult);



    }

    @Test
    void getAllReimbUser() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        Mockito.when(reimbDao.getAllReimbUser(1)).thenReturn(expectedResult);

        List<ReimbModel> actualResult = reimbDao.getAllReimbUser(1);

        assertEquals(expectedResult,actualResult);


    }

    @Test
    void getOneReimb() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        Mockito.when(reimbDao.getOneReimb(1)).thenReturn(expectedResult.get(0));

        ReimbModel actualResult = reimbDao.getOneReimb(1);

        assertEquals(expectedResult.get(0),actualResult);


    }

    @Test
    void createReimb() {
        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");
        ReimbModel reimbToTest = new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1);

        reimbDaoService.createReimb(reimbToTest);

        Mockito.verify(reimbDao, Mockito.times(1)).createReimb(reimbToTest);

    }

    @Test
    void approveReimb() {
    }

    @Test
    void denyReimb() {
    }

    @Test
    void resolveReimbApprove() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        ReimbModel reimbToTest = new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 2, 1);
        reimbDaoService.createReimb(reimbToTest);
        ResolveReimbModel resolve = new ResolveReimbModel(1,2,"approve");

        reimbDao.resolveReimb(resolve);

        Mockito.verify(reimbDao, Mockito.times(1)).resolveReimb(resolve);


    }

    @Test
    void resolveReimbDeny() {

        List<ReimbModel> expectedResult = new ArrayList<>();

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

        expectedResult.add(new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(2, 40.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        expectedResult.add(new ReimbModel(3, 50.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1));
        ReimbModel reimbToTest = new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 2, 1);
        reimbDaoService.createReimb(reimbToTest);
        ResolveReimbModel resolve = new ResolveReimbModel(1,2,"deny");

        reimbDao.resolveReimb(resolve);

        Mockito.verify(reimbDao, Mockito.times(1)).resolveReimb(resolve);


    }

    @Test
    void deleteReimb() {

        Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");
        ReimbModel reimbToTest = new ReimbModel(1, 30.00, date, null, "Pet Goldfish killed", null, 1, null, 1, 1);
        reimbDaoService.createReimb(reimbToTest);
        reimbDaoService.deleteReimb(1);

        Mockito.verify(reimbDao, Mockito.times(1)).deleteReimb(1);



    }
}