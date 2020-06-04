package com.idk.covid19.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idk.covid19.configuration.Covid19Properties;
import com.idk.covid19.model.db.User;
import com.idk.covid19.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private Covid19Properties covid19Properties;

    @MockBean
    private UserDetailsService userDetailsService;

    private ObjectMapper mapper = new ObjectMapper();
    private final String id = "123";
    private User response = new User(id, "Robert Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
    private String jsonAsText;

    @BeforeEach
    public void setup() throws JsonProcessingException {
        jsonAsText = mapper.writeValueAsString(response);
    }

    @Test
    public void testGetUser() throws Exception {
        // Given
        when(userService.getUser(id)).thenReturn(response);
        // Then Expect
        mvc.perform(get("/api/1.0/user/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonAsText));
    }

    @Test
    public void testCreateValidUser() throws Exception {
        // Given
        User newUser = new User(null, "Robert Smith", 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        when(userService.createOrUpdateUser(newUser)).thenReturn(response);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(jsonAsText));
    }

    @Test
    public void testUpdateValidUser() throws Exception {
        // Given
        when(userService.createOrUpdateUser(response)).thenReturn(response);
        // Then Expect
        mvc.perform(put("/api/1.0/user/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(response))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonAsText));
    }

    @Test
    public void testWithInvalidUserWithMissingName() throws Exception {
        // Given
        User newUser = new User(null, null, 36, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testWithInvalidUserWithAgeIsTooYoung() throws Exception {
        // Given
        User newUser = new User(null, "Robert Smith", 0, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testWithInvalidUserWithAgeIsTooOld() throws Exception {
        // Given
        User newUser = new User(null, "Robert Smith", 101, "Male", Arrays.asList("Australia"), "rob.smith@hotmail.com", null);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testWithInvalidUserWithNoRegions() throws Exception {
        // Given
        User newUser = new User(null, "Robert Smith", 10, "Male", null, "rob.smith@hotmail.com", null);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testWithInvalidUserWithBadEmail() throws Exception {
        // Given
        User newUser = new User(null, "Robert Smith", 10, "Male", Arrays.asList("Australia"), "rob.smith", null);
        // Then Expect
        mvc.perform(post("/api/1.0/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newUser))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}