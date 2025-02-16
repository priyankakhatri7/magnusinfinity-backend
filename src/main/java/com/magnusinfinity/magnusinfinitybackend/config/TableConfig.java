package com.magnusinfinity.magnusinfinitybackend.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TableConfig {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @PostConstruct
    public void createTable(){
        try {
            amazonDynamoDB.describeTable("ProductInfo");
        } catch (Exception e) {

            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(ProductInfo.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        }

        try {
            amazonDynamoDB.describeTable("Candidate");
        } catch (Exception e){
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Candidate.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        }

        try {
            amazonDynamoDB.describeTable("Employer");

        } catch (Exception e){
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Employer.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        }

        try {
            amazonDynamoDB.describeTable("Company");

        } catch (Exception e){
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Company.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        }

        try {
            amazonDynamoDB.describeTable("User");
//            amazonDynamoDB.deleteTable("User");
//            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//            CreateTableRequest tableRequest = dynamoDBMapper
//                    .generateCreateTableRequest(User.class);
//            tableRequest.setProvisionedThroughput(
//                    new ProvisionedThroughput(1L, 1L));
//            tableRequest.getGlobalSecondaryIndexes().get(0).setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//            amazonDynamoDB.createTable(tableRequest);
        } catch (Exception e){
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(User.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            tableRequest.getGlobalSecondaryIndexes().get(0).setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        }
    }
}
