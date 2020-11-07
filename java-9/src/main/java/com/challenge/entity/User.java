package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners({})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1,max = 100)
    private String fullName;

    @NotNull
    @Size(min = 1, max = 100)
    @Email
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String nickname;

    @NotNull
    @NotEmpty
    @Column(length = 255)
    @Size(min = 1, max = 255)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Submission> submission = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
