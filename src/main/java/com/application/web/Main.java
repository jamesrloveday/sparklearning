package com.application.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {

    public static void main(String... args) {
        Logger log = LoggerFactory.getLogger("Root logger");
        port(6000);
        get("/hello/:name", (req, res) -> "Hello " + req.params(":name"));
        log.info("Serving the hello page");
        get("/health", ((request, response) -> "Alive"));
        log.info("Healthcheck requested");
        get(Path.Web.INDEX, IndexController.serveIndexPage);

        //form submit example
        get("/form/submit", ((request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("", "");
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "/pages/formsubmit"));
        }));

        post("/form/submit", ((request, response) -> "Hello " + request.queryParams("name")));
    }
}
