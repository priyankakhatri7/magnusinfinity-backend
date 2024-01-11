package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Admin;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import java.util.Optional;

public interface AdminRepository extends DynamoDBCrudRepository<Admin, String > {

    Optional<Admin> findById(String id);
}
