package com.aziz.tweet.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest
{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;

}
