package edu.escuelaing.arep.securespark.service;
import com.google.gson.Gson;

import java.time.LocalDate;

import static spark.Spark.*;

public class DateSecureService {

    public static void main(String[] args){
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystoreOtherService.p12", "123456", "keystores/trustStoreOtherServicer", "654321");
        port(getPort());
        get("/actualtime", (req,res)->{
            return new Gson().toJson(LocalDate.now());
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
