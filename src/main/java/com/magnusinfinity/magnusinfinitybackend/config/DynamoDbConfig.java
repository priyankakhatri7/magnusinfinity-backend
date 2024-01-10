package com.magnusinfinity.magnusinfinitybackend.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.magnusinfinity.magnusinfinitybackend.dao.repository")
public class DynamoDbConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB
                = new AmazonDynamoDBClient(amazonAWSCredentials());

        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }



        return amazonDynamoDB;
    }

//    @Bean
//    public DynamoDbClient getDynamoDbClient() {
//        AwsCredentialsProvider credentialsProvider =
//                DefaultCredentialsProvider.builder()
//                        .profileName("pratikpoc")
//                        .build();
//
//        return DynamoDbClient.builder()
//                .region(Region.US_EAST_1)
//                .credentialsProvider(credentialsProvider).build();
//    }

//    @Bean
//    public DynamoDbEnhancedClient getDynamoDbEnhancedClient() {
//        return DynamoDbEnhancedClient.builder()
//                .dynamoDbClient(amazonDynamoDB())
//                .build();
//    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey);
    }
}