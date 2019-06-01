package ru.adeg.dms.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {

    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String welcome()
    {
        return "startPage";
    }
}
