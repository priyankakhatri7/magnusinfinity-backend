package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Candidate;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import java.util.Optional;

public interface CandidateRepository extends DynamoDBCrudRepository<Candidate, String> {
    Optional<Candidate> findById(String id);
}
