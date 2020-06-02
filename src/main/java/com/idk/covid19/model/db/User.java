package com.idk.covid19.model.db;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.validation.constraints.*;
import java.util.List;

@DynamoDBTable(tableName = "User")
public class User {

    private String id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;
    @NotNull
    @Pattern(regexp = "Male|Female")
    private String gender;
    @NotNull
    private List<String> regions;
    @Pattern(regexp = ".*@.*")
    private String email;
    private String sms;

    public User() {
    }

    public User(String id, String name, Integer age, String gender, List<String> regions, String email, String sms) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.regions = regions;
        this.email = email;
        this.sms = sms;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @DynamoDBAttribute
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @DynamoDBAttribute
    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute
    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", regions=" + regions +
                ", email='" + email + '\'' +
                ", sms='" + sms + '\'' +
                '}';
    }
}