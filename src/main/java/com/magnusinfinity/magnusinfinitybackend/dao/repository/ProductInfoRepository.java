package com.magnusinfinity.magnusinfinitybackend.dao.repository;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableScan
public interface ProductInfoRepository extends DynamoDBCrudRepository<ProductInfo, String> {
    Optional<ProductInfo> findById(String id);
}