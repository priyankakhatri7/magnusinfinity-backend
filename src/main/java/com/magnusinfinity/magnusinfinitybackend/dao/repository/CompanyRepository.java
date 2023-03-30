package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Company;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import java.util.Optional;

public interface CompanyRepository extends DynamoDBCrudRepository<Company, String> {
    Optional<Company> findById(String id);
}
