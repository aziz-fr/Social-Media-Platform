package com.aziz.ReplyService.external.client;

import com.aziz.ReplyService.model.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE/api/v1.0/users")
public interface UserService
{
    @GetMapping("/{id}")
    public UserRequest getUserById(@PathVariable Long id);
}
