package org.raghav.mycrudapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String ShowHomePage(){
        return "index";
    }
}
