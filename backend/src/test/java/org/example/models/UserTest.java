package org.example.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

   User testUser;

   @Test
   @DisplayName("Getting username")
   void testGetUsername() {
      assertEquals("user 1", testUser.getPassword(), "Not user 1");
   }

   @Test
   void setUsername() {
   }

   @Test
   void getPassword() {
   }

   @Test
   void setPassword() {
   }
}