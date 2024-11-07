package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){return userRepository.findAll();}

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(int userId, User user){
        User existing  = getUserById(userId);

        existing.setUserName(user.getUserName());
        existing.setUserType(user.getUserType());
        userRepository.save(existing);
    }

    public void deleteUserById(int userId){userRepository.deleteById(userId);}


}
