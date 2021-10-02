package guru.springframework.pnafspetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    public IndexController() {
    }

    @RequestMapping({"", "/", "/index.html"})
    public String index() {
        return "index";
    }
}