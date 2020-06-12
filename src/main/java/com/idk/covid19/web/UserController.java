package com.idk.covid19.web;

import com.idk.covid19.model.db.DecoratedUser;
import com.idk.covid19.model.db.User;
import com.idk.covid19.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${covid19.api-version}")
@Api(description = "Endpoint for performing CRUD operations on the sign-up users of the Covid-19 application.")
public class UserController {

    public final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ApiOperation("Returns the id of the newly created user, within the user object, given that the parameters received in the submitted POST are valid.")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.createOrUpdateUser(user);
    }

    @PutMapping("/user/{id}")
    @ApiOperation("Returns the id of the updated user, within the user object, given that the parameters received in the submitted PUT are valid.")
    @ApiParam("id represents the primary key of the given user and equates to its DynamoDb Partition key.")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody @Valid User user, @PathVariable String id) {
        user.setId(id);
        return userService.createOrUpdateUser(user);
    }

    @GetMapping("/user/list")
    @ApiOperation("Returns all the user's currently saved in the Covid-19 application.")
    @ResponseStatus(HttpStatus.OK)
    public List<DecoratedUser> getListOfAllUsers() {
        return userService.getListOfAllUsers();
    }

    @GetMapping("/user/{id}")
    @ApiOperation("Returns the user associated with the provided key stored in the Covid-19 application.")
    @ApiParam("id represents the primary key of the given user and equates to its DynamoDb Partition key.")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("Removes the user associated with the provided key, from the Covid-19 application database.")
    @ApiParam("id represents the primary key of the given user and equates to its DynamoDb Partition key.")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}