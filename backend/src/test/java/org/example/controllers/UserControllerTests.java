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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
   @WithMockUser(authorities = "ADMIN")
   @ParameterizedTest
   @ValueSource(strings = { "admin", "user 1", "user 14" })
   @DisplayName("Setting username")
   void testSetUsername(String candidateUsername) {
      testUser.setUsername(candidateUsername);
      assertEquals(candidateUsername, testUser.getUsername(), "Failed to update username to: " + candidateUsername);
   }

   @Test
   @DisplayName("")
   void someTest() {
   }
}
