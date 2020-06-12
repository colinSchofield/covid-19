package com.idk.covid19.service;

import com.idk.covid19.exception.NotFoundException;
import com.idk.covid19.model.db.DecoratedUser;
import com.idk.covid19.model.db.User;
import com.idk.covid19.model.db.repository.UserRepository;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Autowired
    @InjectMocks
    private UserService userService;

    @Mock
    private CountryFlagEmojiUtil flags;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        // Given
        final String id = "123";
        User request = new User(null, "Rob Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        User response = new User(id, "Rob Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        when(userRepository.save(request)).thenReturn(response);
        // When
        User result = userService.createOrUpdateUser(request);
        // Then
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testUpdateUser() {
        // Given
        final String id = "123";
        User request = new User(id, "Robert Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        User response = new User(id, "Robert Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        when(userRepository.save(request)).thenReturn(response);
        // When
        User result = userService.createOrUpdateUser(request);
        // Then
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testListOfAllUsers() {
        // Given
        User user1 = new User("123", "Robert Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        DecoratedUser dUser1 = new DecoratedUser(user1, "", "");
        User user2 = new User("124", "Anne Smith", 28, "Male", Arrays.asList("Canada"), null, null);
        DecoratedUser dUser2 = new DecoratedUser(user2, "", "");
        User[] array = {dUser1, dUser2};
        Iterable<User> iterable = Arrays.stream(array).collect(Collectors.toList());
        when(userRepository.findAll()).thenReturn(iterable);
        // When
        List<DecoratedUser> list =  userService.getListOfAllUsers();
        //Then
        assertNotNull(list);
        assertEquals(2, list.size());
        assertTrue(list.contains(dUser1) && list.contains(dUser2), "Contains both decoracted user1 and user2");
    }

    @Test
    public void testGetUser() {
        // Given
        final String id = "123";
        User response = new User(id, "Anne Smith", 28, "Male", Arrays.asList("Canada"), null, null);
        when(userRepository.findById(id)).thenReturn(Optional.of(response));
        // When
        User result = userService.getUser(id);
        // Then
        assertNotNull(result);
        assertEquals(response, result);
    }

    @Test
    public void testGetUserNotFound() {
        // Given
        final String idNotFound = "666";
        when(userRepository.findById(idNotFound)).thenThrow(NotFoundException.class);
        // When, Then Expect NotFoundException
        assertThrows(NotFoundException.class, () -> {
            userService.getUser(idNotFound);
        });
    }

    @Test
    void testDeleteValidUser() {
        // Given
        final String id = "123";
        User response = new User(id, "Anne Smith", 28, "Male", Arrays.asList("Canada"), null, null);
        when(userRepository.findById(id)).thenReturn(Optional.of(response));
        // When
        userService.deleteUser(id);
        // Then  No Exception
        assertTrue(true, "No Exception is thrown because this is a valid user");
    }

    @Test
    void testDeleteInvalidUser() {
        // Given
        final String idNotFound = "666";
        when(userRepository.findById(idNotFound)).thenThrow(NotFoundException.class);
        // When, Then Expect NotFoundException
        assertThrows(NotFoundException.class, () -> {
            userService.deleteUser(idNotFound);
        });
    }
}