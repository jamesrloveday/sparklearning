package com.application.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by james on 03/05/2017.
 */
public class RouteHandler {
    public static void initRoutes() {
        Logger log = LoggerFactory.getLogger("Root logger");
        get("/hello/:name", (req, res) -> "Hello " + req.params(":name"));
        log.info("Serving the hello page");
        get("/health", ((request, response) -> "Alive"));
        log.info("Healthcheck requested");
        get(Path.Web.INDEX, Router.serveIndexPage);

        get(Path.Web.SUBMIT, Router.serveSubmitPage);

        post(Path.Web.SUBMIT, Router.handleSubmitForm);
    }
}
