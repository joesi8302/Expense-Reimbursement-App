package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ReimbDao;
import io.javalin.http.Context;
import models.ReimbModel;
import models.ResolveReimbModel;
import services.ReimbDaoService;

import java.util.List;

public class ReimbController  {

    static ReimbDaoService reimbDaoService = new ReimbDaoService();


    public static void getAllReimb(Context context) throws JsonProcessingException {
        context.contentType("application/json");

        List<ReimbModel> reimbList = reimbDaoService.getAllReimb();

        String jsonString = new ObjectMapper().writeValueAsString(reimbList);

        context.result(jsonString);
    }


    public static void getAllReimbUser(Context context) throws JsonProcessingException{

        context.contentType("application/json");

        Integer reimb_id = Integer.parseInt(context.pathParam("id"));

        List<ReimbModel> reimbList = reimbDaoService.getAllReimbUser(reimb_id);

        String jsonString = new ObjectMapper().writeValueAsString(reimbList);

        context.result(jsonString);

    }


    public static void getOneReimb(Context context) throws JsonProcessingException{
        context.contentType("application/json");

        Integer reimb_id = Integer.parseInt(context.pathParam("id"));

        ReimbModel reimb = reimbDaoService.getOneReimb(reimb_id);

        String jsonString = new ObjectMapper().writeValueAsString(reimb);

        context.result(jsonString);
    }


    public static void createReimb(Context context) throws JsonProcessingException{
        context.contentType("application/json");
        ReimbModel reimb = context.bodyAsClass(ReimbModel.class);

        reimbDaoService.createReimb(reimb);
        context.result("reimb has been created");

    }


    public static void approveReimb(Context context) throws JsonProcessingException{

    }


    public static void denyReimb(Context context) throws JsonProcessingException{

    }

    public static void resloveReimb(Context context) throws JsonProcessingException{

        ResolveReimbModel resolve = context.bodyAsClass(ResolveReimbModel.class);

        reimbDaoService.resolveReimb(resolve);

        context.result("Reimbursment updated");



    }


    public static void deleteReimb(Context context) throws JsonProcessingException{

        Integer reimb_id = Integer.parseInt(context.pathParam("id"));

        reimbDaoService.deleteReimb(reimb_id);



    }
}
