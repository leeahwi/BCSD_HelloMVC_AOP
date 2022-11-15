package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "hellobody", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {

        try
        {
            Thread.sleep(100);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "Hello Spring (text)";
    }

    @RequestMapping(value ="hello", method = RequestMethod.GET)
    public String helloBody() {
        try
        {
            Thread.sleep(100);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "hello";
    }
}