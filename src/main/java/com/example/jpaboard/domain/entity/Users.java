package com.example.jpaboard.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
public class Users {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @Column(columnDefinition = "integer default 0")
    private int loginCount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
    private Date createAt;

    public static Users createUser(String email, String password) {
        return new Users(email, password);
    }

    private Users(String email, String password) {
        this.email = email;
        this.password = password;
        this.loginCount = 0;
    }

    public Users() {
    }
}
