package com.ivoronline.springboot_accessories_threadlocal_filter_instance.context;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

  //PROPERTIES
  private static final ThreadLocal<String> user = new ThreadLocal<>();
  
  //=========================================================================================================
  // GET USER
  //=========================================================================================================
  public static String getUser() {
    return user.get();
  }
  
  //=========================================================================================================
  // SET USER
  //=========================================================================================================
  public static void setUser(String newUser) {
    user.set(newUser);
  }
  
  //=========================================================================================================
  // CLEAR
  //=========================================================================================================
  public static void clear() {
    user.remove();
  }
  
}
