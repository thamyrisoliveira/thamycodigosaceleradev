package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select c.id.user from Candidate c where c.id.acceleration.name= :name ")
    List<User> findByAccelerationName(String name);
    @Query(" select c.id.user from Candidate c where c.id.company.id= :companyId")
    List<User> findByCompanyId(Long companyId);
}

