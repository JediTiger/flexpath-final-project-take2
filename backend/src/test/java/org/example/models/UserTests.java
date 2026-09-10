package org.example.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

// Testing Model User methods
@SpringBootTest
@ActiveProfiles("test") // Activates application-test.properties
class UserTests {

   User testUser;

   @Test
   @DisplayName("MODEL TEST: Getting username")
   void testGetUsername() {
      assertEquals("user 1", testUser.getPassword(), "Not user 1");
   }

   @Test
   @DisplayName("MODEL TEST: Setting username")
   void setUsername() {
   }

   @Test
   @DisplayName("MODEL TEST: Getting password")
   void getPassword() {
   }

   @Test
   @DisplayName("MODEL TEST: Setting username")
   void setPassword() {
   }
}