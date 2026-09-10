package org.example.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// Testing User model class methods
@DisplayName("User model unit tests")
class UserTests {

   private User testUser;

   @BeforeEach
   void setUpTestUser() {
      testUser = new User("user 1", "password");
   }

   @Test
   @DisplayName("Getting username")
   void testGetUsername() {
      assertEquals("user 1", testUser.getUsername(), "Not user 1");
   }

   @Test
   @DisplayName("Username does not exist")
   void testWrongUsername() {
      assertNotEquals("user 2", testUser.getUsername(), "Not user 1");
   }

   @ParameterizedTest
   @ValueSource(strings = { "admin", "user 1", "user 14" })
   @DisplayName("Setting username")
   void testSetUsername(String candidateUsername) {
      testUser.setUsername(candidateUsername);
      assertEquals(candidateUsername, testUser.getUsername(), "Failed to update username to: " + candidateUsername);
   }

   @Test
   @DisplayName("Getting password")
   void getPassword() {
      assertEquals("password", testUser.getPassword(), "Not password");
   }

   @Test
   @DisplayName("Setting password")
   void setPassword() {
      testUser.setPassword("notApassword");
      // verify password was changed
      assertEquals("notApassword", testUser.getPassword(), "Password should be 'notApassword'");
      // Verify password is not still the old password
      assertNotEquals("password", testUser.getPassword(), "Password should not be 'passwprd'");
   }
}