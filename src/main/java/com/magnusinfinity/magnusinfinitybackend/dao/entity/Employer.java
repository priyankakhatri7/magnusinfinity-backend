package com.magnusinfinity.magnusinfinitybackend.dao.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@DynamoDBTable(tableName = "Employer")
public class Employer {

    @Id
    @DynamoDBHashKey
    private String emailId;

    @DynamoDBAttribute
    private String fullName;

    @DynamoDBAttribute
    private String mobileNumber;

    @DynamoDBAttribute
    private String password; // put it encrypted

    @DynamoDBAttribute
    private String companyName;

    @DynamoDBAttribute
    private String designation;

    @DynamoDBAttribute
    private Date createdAt;

    @DynamoDBAttribute
    private Date updatedAt;
}
