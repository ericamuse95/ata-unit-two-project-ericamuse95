/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kenzie.unit.two.iam.lambda;

import com.kenzie.unit.two.App;
import com.kenzie.unit.two.iam.models.User;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

public class GetUsers implements RequestHandler<Map<String, String>, List<User>> {

    // Handler value: example.Handler
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Override
    public List<User> handleRequest(Map<String, String> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));

        return App.userService().getUsers();
    }
}