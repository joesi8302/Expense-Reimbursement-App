package frontcontroller;

import controllers.ReimbController;
import controllers.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {
    public Dispatcher(Javalin app){
        //app.post("/reimb",);

        //app.get("/reimb", ReimbController::getAllReimb);

        app.routes(() -> {
            path("reimb",() -> {
                get(ReimbController::getAllReimb);
                post(ReimbController::createReimb);
                patch(ReimbController::resloveReimb);

                path("{id}", () ->{
                    get(ReimbController:: getOneReimb);
                    delete(ReimbController::deleteReimb);
                });
                path("user", () -> {
                    post(UserController::createUser);

                    path("{id}", () ->{
                        get(ReimbController::getAllReimbUser);
                    });
                });
            });
        });

        app.routes(() -> {
            path("api", () -> {
                get(UserController::checkUserLogin);
                post(UserController::userLogin);
                delete(UserController::userLogout);
            });
        });

    }
}
