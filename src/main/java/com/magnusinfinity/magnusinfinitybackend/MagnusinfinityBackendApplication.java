package com.magnusinfinity.magnusinfinitybackend;

import com.magnusinfinity.magnusinfinitybackend.config.AppProperties;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.UserRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableDynamoDBRepositories
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MagnusinfinityBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(MagnusinfinityBackendApplication.class, args);

	}

}
