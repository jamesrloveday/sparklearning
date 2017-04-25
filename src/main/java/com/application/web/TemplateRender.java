package com.application.web;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public class TemplateRender {
        public static String render(Map<String, Object> model, String path) {
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, path));
        }
}