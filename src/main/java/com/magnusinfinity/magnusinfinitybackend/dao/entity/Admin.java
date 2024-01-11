package com.magnusinfinity.magnusinfinitybackend.dao.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @DynamoDBHashKey
    private String emailId;

    @DynamoDBAttribute
    private String fullName;

    @DynamoDBAttribute
    private String mobileNumber;
}
