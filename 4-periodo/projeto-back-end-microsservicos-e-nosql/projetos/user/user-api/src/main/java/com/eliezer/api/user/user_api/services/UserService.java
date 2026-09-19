package com.eliezer.api.user.user_api.services;

import com.eliezer.api.user.user_api.models.User;
import com.eliezer.api.user.user_api.models.dto.UserDTO;
import com.eliezer.api.user.user_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public User createUser(UserDTO userDTO) {
        // Verificar se CPF já existe
        if (userRepository.existsByCpf(userDTO.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        
        // Verificar se email já existe
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        User user = User.builder()
                .nome(userDTO.getNome())
                .cpf(userDTO.getCpf())
                .endereco(userDTO.getEndereco())
                .email(userDTO.getEmail())
                .telefone(userDTO.getTelefone())
                .dataCadastro(LocalDateTime.now())
                .build();
        
        return userRepository.save(user);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
    
    public User updateUser(String id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        // Verificar se CPF já existe em outro usuário
        if (!existingUser.getCpf().equals(userDTO.getCpf()) && 
            userRepository.existsByCpf(userDTO.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        
        // Verificar se email já existe em outro usuário
        if (!existingUser.getEmail().equals(userDTO.getEmail()) && 
            userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        existingUser.setNome(userDTO.getNome());
        existingUser.setCpf(userDTO.getCpf());
        existingUser.setEndereco(userDTO.getEndereco());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setTelefone(userDTO.getTelefone());
        
        return userRepository.save(existingUser);
    }
    
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }
}
