package com.magnusinfinity.magnusinfinitybackend.dao.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@DynamoDBTable(tableName = "Company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @DynamoDBHashKey
    private String companyName;

    @DynamoDBAttribute
    private String companyUrl;

    @DynamoDBAttribute
    private String mobileNumber;

    @DynamoDBAttribute
    private String emailId;

    @DynamoDBAttribute
    private List<String> locations;

    @DynamoDBAttribute
    private String linkedinUrl;

    @DynamoDBAttribute
    private Date createdAt;

    @DynamoDBAttribute
    private Date updatedAt;

}
