package com.gusrubin.legacyrest.controller;

import com.gusrubin.legacyrest.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gustavo Rubin
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

  @GetMapping
  public List<User> getAll() {
    return generateSampleUsers(3);
  }

  public static List<User> generateSampleUsers(int count) {
    List<User> users = new ArrayList<>();
    for (int i = 1; i <= count; i++) {
      User user = new User();
      user.setName("User " + i);
      user.setEmail("user" + i + "@example.com");
      users.add(user);
    }
    return users;
  }
}
