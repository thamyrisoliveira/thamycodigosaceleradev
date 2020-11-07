package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    @Query("select c from Candidate c where c.id.company.id = :companyId")
    List<Candidate> findByCompanyId(Long companyId);

    @Query("select c from Candidate c where c.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(Long accelerationId);
}
