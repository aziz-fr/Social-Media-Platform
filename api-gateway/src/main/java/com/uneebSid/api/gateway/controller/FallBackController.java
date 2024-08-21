package com.uneebSid.api.gateway.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class FallBackController
{

    @PostMapping("/userServiceFallBack")
    public String userServiceFallBack()
    {
        return "user service is down at the moment!";
    }

    @PostMapping("/tweetServiceFallBack")
    public String tweetServiceFallBack()
    {
        return "tweet service is down at the moment!";
    }

    @PostMapping("/replyServiceFallBack")
    public String replyServiceFallBack()
    {
        return "reply service is down at the moment!";
    }

    @PostMapping("/likeServiceFallBack")
    public String likeServiceFallBack()
    {
        return "like service is down at the moment!";
    }

    @PostMapping("/tagServiceFallBack")
    public String tagServiceFallBack()
    {
        return "tag service is down at the moment!";
    }

}
