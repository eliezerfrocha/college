package com.user.user_api.services;

import com.user.user_api.models.User;
import com.user.user_api.models.UserDTO;
import com.user.user_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(@NonNull String id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
    
    public List<User> searchUsersByName(String nome) {
        return userRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    @NonNull
    public Page<User> getAllUsersPageable(@NonNull Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    
    @NonNull
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setCpf(userDTO.getCpf());
        user.setEndereco(userDTO.getEndereco());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(LocalDateTime.now());
        
        return userRepository.save(user);
    }
    
    public User updateUser(@NonNull String id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setNome(userDTO.getNome());
            user.setCpf(userDTO.getCpf());
            user.setEndereco(userDTO.getEndereco());
            user.setEmail(userDTO.getEmail());
            user.setTelefone(userDTO.getTelefone());
            
            return userRepository.save(user);
        }
        return null;
    }
    
    public User patchUser(@NonNull String id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            
            if (userDTO.getNome() != null) {
                user.setNome(userDTO.getNome());
            }
            if (userDTO.getCpf() != null) {
                user.setCpf(userDTO.getCpf());
            }
            if (userDTO.getEndereco() != null) {
                user.setEndereco(userDTO.getEndereco());
            }
            if (userDTO.getEmail() != null) {
                user.setEmail(userDTO.getEmail());
            }
            if (userDTO.getTelefone() != null) {
                user.setTelefone(userDTO.getTelefone());
            }
            
            return userRepository.save(user);
        }
        return null;
    }
    
    public boolean deleteUser(@NonNull String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
