package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {
    @Query("select COALESCE(MAX(s.score), 0) from Submission s where s.id.challenge.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    @Query("select s from Submission s " +
            "join s.id.challenge c " +
            "join c.accelerations a where c.id= :challengeId AND a.id= :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
