package com.idk.covid19.service;

import com.idk.covid19.exception.NotFoundException;
import com.idk.covid19.model.db.DecoratedUser;
import com.idk.covid19.model.db.User;
import com.idk.covid19.model.db.repository.UserRepository;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    public final static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryFlagEmojiUtil flags;

    public User createOrUpdateUser(User user) {
        LOG.debug("About to create/update a user with properties: {}", user.toString());
        User response = userRepository.save(user);
        LOG.debug("User created/updated with id of {}", response.getId());
        return response;
    }

    public List<DecoratedUser> getListOfAllUsers() {
        return StreamSupport.
                stream(userRepository.findAll().spliterator(), false)
                .map(this::decorateUser)
                .sorted(Comparator.comparing(DecoratedUser::getName))
                .collect(Collectors.toList());
    }

    private DecoratedUser decorateUser(User user) {
        String regionList = user.getRegions()
                .stream()
                .reduce("", (acc, combo) ->
                {
                    return acc + " " + flags.getEmojiForCountry(combo);
                });
        String contact = (StringUtils.isNotEmpty(user.getEmail()) ? "💌" : "") + " " +
                (StringUtils.isNotEmpty(user.getSms()) ? "💬" : "");

        return new DecoratedUser(user, regionList, contact);
    }

    public User getUser(String id) {
        LOG.debug("About to obtain the user for id of {}", id);
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteUser(String id) {
        LOG.debug("About to delete the user for id of {}", id);
        userRepository.delete(this.getUser(id));
        LOG.debug("User delete successfully");
    }
}