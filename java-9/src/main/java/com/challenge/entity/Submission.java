package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners({})
public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @NotNull
    private Float score;

    @CreatedDate
    private LocalDateTime createdAt;

    public SubmissionId getId() {
        return id;
    }

    public void setId(SubmissionId id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }




}
