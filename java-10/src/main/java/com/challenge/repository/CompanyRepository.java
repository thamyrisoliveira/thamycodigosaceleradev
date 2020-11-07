package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("select DISTINCT c from Company c " +
            "join c.candidates ca where ca.id.acceleration.id = :accelerationId ")
    List<Company> findByAccelerationId(Long accelerationId);

    @Query("select c.id.company from Candidate c where c.id.user.id = :userId ")
    List<Company> findByUserId(Long userId);
}
