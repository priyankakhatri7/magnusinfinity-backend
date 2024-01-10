package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Employer;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import java.util.Optional;

public interface EmployerRepository extends DynamoDBCrudRepository<Employer, String> {
    Optional<Employer> findById(String id);

}
