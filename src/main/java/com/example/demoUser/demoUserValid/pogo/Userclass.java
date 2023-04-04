package com.example.demoUser.demoUserValid.pogo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "users")
public class Userclass {

    @Id
    private String id;
    private String name;
    private String email;
    private String gender;
    private String dob;
    private int age;
    private Address address;
    private List<String> roles;

    public Userclass() {
    }

    public Userclass(String name, String email, String gender, String dob, int age, Address address, List<String> roles) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.address = address;
        this.roles = roles;
    }

    // getters and setters
}

