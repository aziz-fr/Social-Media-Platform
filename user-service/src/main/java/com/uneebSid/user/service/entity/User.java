package com.uneebSid.user.service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @NotEmpty(message = "First Name can not be empty or null")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Last Name can not be empty or null")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(message = "Email can not be empty or null")
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "userId can not be empty or null")
    @Column(unique = true, nullable = false)
    private String username;

    @NotEmpty(message = "password can not be empty or null")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Phone number can not be empty or null")
    @Column(nullable = false)
    private String phoneNumber;


}

