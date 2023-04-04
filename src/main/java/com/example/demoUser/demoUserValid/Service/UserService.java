package com.example.demoUser.demoUserValid.Service;
import com.example.demoUser.demoUserValid.Repo.UserRepository;
import com.example.demoUser.demoUserValid.pogo.Userclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Userclass> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Userclass> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Object addUser(Userclass user){
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "The email ID already exists";
        }
        if (user.getAge() < 18) {
            return "Invalid age";
        }
        return userRepository.save(user);
    }

    public void deleteUser(String id, List<String> roles) {
        Userclass user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (!roles.contains("admin") && !roles.contains("superAdmin")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to delete this user");
        }
        userRepository.deleteById(id);
    }
    }

