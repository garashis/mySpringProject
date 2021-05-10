package com.example.mySpringProject;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//@ConfigurationProperties("example")
public class DBConfiguration {
    private String username;

    private String password;
}
