package com.example.pastebin.services;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
   
   public UserData saveUserText(String Text) {
      UserData userData = new UserData();
      userData.setUser_text(Text);
      return userRepository.save(userData);
   }

   public UserData authenticated(String Username, String Password) {
      return userRepository.findByUsernameAndPassword(Username, Password).orElse(null);
   }

   public void getUserIdByUsername(String username, String text) {
      UserData userData = userRepository.findByUsername(username);
      System.out.println("user data : " + userData + "   " + "text :  " + text);
      if (userData != null) {
          Integer Id = userData.getId_user();
          UserData entity = userRepository.findById(Id).orElse(null);
          System.out.println(entity);
          if (entity != null) {
            entity.setUser_text(text);
            userRepository.save(entity);
          }
      } 
   }

   public void getUserTextById(String username, Model model) {
      UserData userData = userRepository.findByUsername(username);
      if (userData != null) {
          Integer Id = userData.getId_user();
          UserData entity = userRepository.findById(Id).orElse(null);
          System.out.println(entity);
          if (entity != null) {
            model.addAttribute("userText", entity.getUser_text());
          }
      } 
  }
}
