package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("select c from Challenge c join c.accelerations a " +
            " join c.submissions s where a.id= :accelerationId and s.id.user.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
}
