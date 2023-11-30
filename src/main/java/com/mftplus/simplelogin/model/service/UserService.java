package com.mftplus.simplelogin.model.service;

import com.mftplus.simplelogin.controller.exception.DuplicateUsernameException;
import com.mftplus.simplelogin.model.entity.User;
import com.mftplus.simplelogin.model.repository.UserRepository;

import java.util.List;


public class UserService {
    private static final UserService userService = new UserService();

    private UserService() {
    }

    public static UserService getUserService(){
        return userService;
    }

    public User save(User user) throws Exception {
        try(UserRepository userRepository = new UserRepository()) {
            if (userRepository.findByUserName(user.getUserName())== null){
                return userRepository.save(user);
            }else {
               throw new DuplicateUsernameException("username is already used!");
            }
        }
    }
    public User login(User user) throws Exception {
        try(UserRepository userRepository = new UserRepository()) {
            return userRepository.findByUserNameAndPassword(user);
        }
    }
    public List<User> findAll() throws Exception {
        try(UserRepository userRepository = new UserRepository()){
            return userRepository.findAll();
        }
    }

}
