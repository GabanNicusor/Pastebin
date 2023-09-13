package com.example.pastebin.services;
import org.springframework.stereotype.Service;

import com.example.pastebin.entities.UserData;
import com.example.pastebin.repository.UserRepository;

@Service
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public UserData registerUser(String Username, String Password) {
      if (Username == null && Password == null) {
         return null;
      } else {
         UserData userData = new UserData();
         userData.setNameuser(Username);
         userData.setPassworduser(Password);
         return userRepository.save(userData);
      }
   }
   
   public UserData searchUser(String Username) {
      return userRepository.findByUsername(Username);
   }

   public UserData authenticated(String Username, String Password) {
      return userRepository.findByUsernameAndPassword(Username, Password).orElse(null);
   }
}
