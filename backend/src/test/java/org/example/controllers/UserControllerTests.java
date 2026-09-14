package org.example.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("UserController tests")
public class UserControllerTests {

   // Testing UserController class methods
   // Since testing this controller also tests the DAO it uses to fetch and update data, no need to test the DAO alone

   @Autowired
   private MockMvc mockMvc;

   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("Get all user [as Admin]")
   void testGetAllUsers() throws Exception {
      mockMvc.perform(get("/api/users")
         // Tells the test server I expect a JSON object back
         .contentType(MediaType.APPLICATION_JSON))
         // Verify the returned status is 200
         .andExpect(status().isOk())
         // Verifies the exact names of all the 3 users are returned
         .andExpect(jsonPath("$[0].username").value("admin"))
         .andExpect(jsonPath("$[1].username").value("user 1"))
         .andExpect(jsonPath("$[2].username").value("user 2"));
   }

   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("Get a user [as admin]")
   void testGetUserByUsername() throws Exception {
      mockMvc.perform(get("/api/users/user 1")
         .contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk())
         // Verifies the exact name and password of the user
         .andExpect(jsonPath("$.username").value("user 1"))
         .andExpect(jsonPath("$.password").value("$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq"));
   }

   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("get user with wrong username [as admin]")
   void testGetUserNotFound() throws Exception {
      mockMvc.perform(get("/api/users/no_user")
         .contentType(MediaType.APPLICATION_JSON))
         // This is set to ok because the provided UserDao returns null when a user is not found instead of 404
         .andExpect(status().isOk())
         // This is the actual check as it confirms the user object does not exist
         .andExpect(jsonPath("$").doesNotExist());
   }

   // TODO: Create a user

   // TODO: Delete at least one user

   // TODO: Update a users password

   // Test should pass with the incorrect authority passed
   @Test
   @WithMockUser(authorities = "USER")
   @DisplayName("get all users [as user]")
   void testGetAllUsersAccessDenied() throws Exception {
      mockMvc.perform(get("/api/users")
         .contentType(MediaType.APPLICATION_JSON))
         // Verifies that the status response is 403 forbidden
         .andExpect(status().isForbidden());
   }
}


