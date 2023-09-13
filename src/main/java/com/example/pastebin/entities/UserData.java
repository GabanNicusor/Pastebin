package com.example.pastebin.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "datauser"
)
public class UserData {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   Integer id_user;
   String username;
   String password;
   String user_text;

   public UserData() {
   }
   
   public Integer getId_user() {
      return id_user;
   }

   public void setId_user(Integer id_user) {
      this.id_user = id_user;
   }

   public String getNameuser() {
      return this.username;
   }

   public void setNameuser(String username) {
      this.username = username;
   }

   public String getPassworduser() {
      return this.password;
   }

   public void setPassworduser(String password) {
      this.password = password;
   }

   public String getUser_text() {
      return user_text;
   }

   public void setUser_text(String user_text) {
      this.user_text = user_text;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
      result = prime * result + ((username == null) ? 0 : username.hashCode());
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((user_text == null) ? 0 : user_text.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      UserData other = (UserData) obj;
      if (id_user == null) {
         if (other.id_user != null)
            return false;
      } else if (!id_user.equals(other.id_user))
         return false;
      if (username == null) {
         if (other.username != null)
            return false;
      } else if (!username.equals(other.username))
         return false;
      if (password == null) {
         if (other.password != null)
            return false;
      } else if (!password.equals(other.password))
         return false;
      if (user_text == null) {
         if (other.user_text != null)
            return false;
      } else if (!user_text.equals(other.user_text))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "UserData [id_user=" + id_user + ", username=" + username + ", user_text=" + user_text + "]";
   }

}
