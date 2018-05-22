package com.rulexu.controller;

import com.rulexu.Service.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketController {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketController.class);


    WebSocketService webSocketService;


    @RequestMapping(value = "/sendMsg",method = RequestMethod.POST)
    public synchronized @ResponseBody String getBchDepth(){
        String msg = "websocket message...";
        webSocketService.sendMessage(msg);
        return "success";
    }

}
