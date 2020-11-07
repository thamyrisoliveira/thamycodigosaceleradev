package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners({})
public class Candidate {
    @EmbeddedId
    private CandidateId candidateId;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    @CreatedDate
    private LocalDateTime createdAt;

    public CandidateId getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(CandidateId candidateId) {
        this.candidateId = candidateId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
