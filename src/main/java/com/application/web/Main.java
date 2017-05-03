package com.application.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class Main {

    public static void main(String... args) {
        Logger log = LoggerFactory.getLogger("Root logger");
        port(6000);
        RouteHandler.initRoutes();
    }
}
