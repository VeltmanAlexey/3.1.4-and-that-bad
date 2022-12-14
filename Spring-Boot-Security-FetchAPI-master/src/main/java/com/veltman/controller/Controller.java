package com.veltman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.veltman.service.AppService;


@org.springframework.stereotype.Controller
public class Controller {

    private final AppService appService;

    @Autowired
    public Controller(AppService appService) {
        this.appService = appService;
    }

    @GetMapping({"", "/"})
    public String main(Model model, @Nullable Authentication auth) {
        return appService.getPage(model, auth);
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied-page";
    }
}
