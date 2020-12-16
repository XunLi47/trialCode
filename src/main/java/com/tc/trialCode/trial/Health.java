package com.tc.trialCode.trial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Health {

    @RequestMapping(value = "/health")
    @ResponseBody
    public String getHealth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "OK";
    }


    @RequestMapping(value = "/status")
    @ResponseBody
    public int getStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return 200;
    }


}

