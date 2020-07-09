package com.idk.covid19.web;

import com.idk.covid19.model.db.DecoratedUser;
import com.idk.covid19.model.db.User;
import com.idk.covid19.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Validated
@RestController
@RequestMapping("${covid19.api-version}")
public class UserController {

    public final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.createOrUpdateUser(user);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody @Valid User user, @PathVariable String id) {
        user.setId(id);
        return userService.createOrUpdateUser(user);
    }

    @GetMapping("/user/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DecoratedUser> getListOfAllUsers() {
        return userService.getListOfAllUsers();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}