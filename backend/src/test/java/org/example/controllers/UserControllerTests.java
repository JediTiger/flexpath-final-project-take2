package org.example.controllers;

import org.example.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("UserController tests")
public class UserControllerTests {

   // Testing UserController class methods

   // Need to mock a DB so the methods can be tested
   @Autowired
   private MockMvc mockMvc;

   private User testUser;

   @BeforeEach
   void setUpTestUser() {
   }
   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("Test getAllUsers")
   void testGetAllUsers() throws Exception {
      mockMvc.perform(get("/api/users")
         .contentType(MediaType.APPLICATION_JSON))
         // Verify the returned status is 200
         .andExpect(status().isOk())
         // Verify the response is a JSON array required by the what?
         .andExpect(jsonPath("$").isArray())
         // Confirm all 3 users from the test file were returned
         .andExpect(jsonPath("$.length()").value(3))

         // Verifies the specific user data matches your data.sql file exactly
         .andExpect(jsonPath("$[0].username").value("admin"))
         .andExpect(jsonPath("$[1].username").value("usXer 1"))
         .andExpect(jsonPath("$[2].username").value("user 2"));
   }
}


