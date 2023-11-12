package com.example.email.service;

import com.example.email.data.User;
import com.example.email.data.enums.UserRight;
import com.example.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

//    List<User> users = List.of(
//            new User("user","user","$2a$10$XWmt6OEN5EQwUDIcAq8th.7UkcOBjPVXxYiHCdkGceZk4aaEzeidy",new HashSet<>(Arrays.asList(UserRight.USER))),
//            new User("admin","admin","$2a$10$SafFZHyktFIR3nyU3C29ZO.cGVNO/Vo/XU6BAPgdDeaT5pP3vOkJe",new HashSet<>(Arrays.asList(UserRight.ADMIN)))
//    );
//
//    public User findUserByName(String userName) {
//            return users.stream()
//                    .filter(user -> user.getFirstName().equals(userName)).findFirst().orElse(null);
//    }


}
