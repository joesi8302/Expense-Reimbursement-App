package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.UserDao;
import io.javalin.http.Context;
import models.JsonResponse;
import models.UserLoginModel;
import models.UserLoginResponse;
import models.UserModel;
import org.openqa.selenium.json.Json;
import services.UserDaoService;

public class UserController {

    static UserDaoService userDaoService = new UserDaoService();


    public static void userLogin(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        UserLoginModel user = context.bodyAsClass(UserLoginModel.class);

        UserModel userSession = userDaoService.userLogin(user);

        if(userSession == null){
            context.json(new JsonResponse(false, "Login failed", null));
        }
        else{
            UserLoginResponse userResponse = new UserLoginResponse(userSession.getErs_username(), userSession.getErs_user_id(), userSession.getUser_role_id());
            context.sessionAttribute("user-session", userResponse);
            context.json(new JsonResponse(true, "Login Successful", userResponse));
        }

    }


    public static void checkUserLogin(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        UserLoginResponse checkUser = context.sessionAttribute("user-session");


        if(checkUser == null){
            context.json(new JsonResponse(false, "No Session Found",null));
        }else{
            context.json(new JsonResponse(true, "Session Found",checkUser));
        }

    }

    public static void userLogout(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        context.sessionAttribute("user-session", null);
        context.json(new JsonResponse(true, "User has been logged out",null));
    }


    public static void createUser(Context context) throws JsonProcessingException{
        context.contentType("application/json");
        UserModel user = context.bodyAsClass(UserModel.class);

        userDaoService.createUser(user);
        context.json("User Created");
    }


    public static void deleteUser(Context context) throws JsonProcessingException{

    }



}
