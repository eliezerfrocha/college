package com.user.user_api.models.converter;

import com.user.user_api.models.User;
import com.example.dto.UserDTO;

public class DTOConverter {
    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setCpf(user.getCpf());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
