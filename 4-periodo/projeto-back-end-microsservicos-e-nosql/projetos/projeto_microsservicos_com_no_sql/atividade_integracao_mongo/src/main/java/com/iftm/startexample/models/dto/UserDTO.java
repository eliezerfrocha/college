package com.iftm.startexample.models.dto;

import com.iftm.startexample.models.Adress;
import com.iftm.startexample.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private int age;
    private Adress address;

    public UserDTO(User user) {
        this.id = user.getId().toString();
        this.name = user.getName();
        this.age = user.getAge();
        this.address = user.getAddress();
    }
}
