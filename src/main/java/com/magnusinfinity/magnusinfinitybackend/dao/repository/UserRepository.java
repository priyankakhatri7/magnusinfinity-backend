package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableScan
public interface UserRepository extends DynamoDBCrudRepository<User, String> {
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}