package com.application.web;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 25/04/2017.
 */
public class IndexController {

    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("message", "Hello World from spark and thymeleaf");
        return TemplateRender.render(model, Path.Template.INDEX);
    };

}
