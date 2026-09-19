package com.user.user_api.controller;

import com.user.user_api.models.User;
import com.user.user_api.models.UserDTO;
import com.user.user_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @NonNull String id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{cpf}/cpf")
    public ResponseEntity<User> getUserByCpf(@PathVariable String cpf) {
        Optional<User> user = userService.getUserByCpf(cpf);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public List<User> searchUsersByName(@RequestParam(required = false) String nome,
                                       @RequestParam(required = false) String name) {
        String searchTerm = nome != null ? nome : name;
        if (searchTerm == null) {
            return userService.getAllUsers();
        }
        return userService.searchUsersByName(searchTerm);
    }
    
    @GetMapping("/pageable")
    public Page<User> getAllUsersPageable(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(required = false) Integer page1) {
        int pageNumber = page1 != null ? page1 : page;
        Pageable pageable = PageRequest.of(pageNumber, size);
        return userService.getAllUsersPageable(pageable);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable @NonNull String id, @RequestBody @Valid UserDTO userDTO) {
        User updatedUser = userService.updateUser(id, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable @NonNull String id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.patchUser(id, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(@PathVariable @NonNull String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
