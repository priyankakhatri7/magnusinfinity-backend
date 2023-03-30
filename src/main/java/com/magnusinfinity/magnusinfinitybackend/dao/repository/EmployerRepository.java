package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Employer;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

public interface EmployerRepository extends DynamoDBCrudRepository<Employer, String> {

}
