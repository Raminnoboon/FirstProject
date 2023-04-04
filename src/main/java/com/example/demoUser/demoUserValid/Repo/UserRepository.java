package com.example.demoUser.demoUserValid.Repo;

import com.example.demoUser.demoUserValid.pogo.Userclass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Userclass, String> {
    Userclass findByEmail(String email);
}

