package com.aziz.tweet.service.external.client;

import com.aziz.tweet.service.model.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "USER-SERVICE/api/v1.0/users")
public interface UserService
{
    @GetMapping("/{id}")
    public UserRequest getUserById(@PathVariable Long id);

}
