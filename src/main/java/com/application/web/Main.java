package com.application.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class Main {

    public static void main(String... args) {
        Logger log = LoggerFactory.getLogger("Root logger");
        port(6000);
        get("/hello/:name", (req, res) -> "Hello " + req.params(":name"));
        log.info("Serving the hello page");
        get("/health", ((request, response) -> "Alive"));
        log.info("Healthcheck requested");
        get(Path.Web.INDEX, Router.serveIndexPage);

        get(Path.Web.SUBMIT, Router.serveSubmitPage);

        post(Path.Web.SUBMIT, Router.handleSubmitForm);
    }
}
