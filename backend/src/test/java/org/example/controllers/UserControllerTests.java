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

   // Need to mock a DB so the methods can be tested
   @Autowired
   private MockMvc mockMvc;

   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("Get all user [as Admin]")
   void testGetAllUsers() throws Exception {
      mockMvc.perform(get("/api/users")
         // Tells the 'server' I expect a JSON object back
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
         // Tells the test server to return a JSON object
         .contentType(MediaType.APPLICATION_JSON))
         // Verify the returned status is 200
         .andExpect(status().isOk())
         // Verifies the exact name and password of the user
         .andExpect(jsonPath("$.username").value("user 1"))
         .andExpect(jsonPath("$.password").value("$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq"));
   }

   // Try a negative test like a different user that doesn't exist

   // Create a user

   // Delete at least one user

   // Update a users password

}


