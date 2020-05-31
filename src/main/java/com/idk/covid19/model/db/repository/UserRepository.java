package com.idk.covid19.model.db.repository;


import com.idk.covid19.model.db.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/** DynamoDb does not yet support ReactiveCrudRepository :-/ */
@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
}