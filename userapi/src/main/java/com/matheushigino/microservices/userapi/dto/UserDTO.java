package com.matheushigino.microservices.userapi.dto;

import com.matheushigino.microservices.userapi.model.User;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    private String endereco;
    private String key;
    @NotBlank(message = "E-mail é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setKey(user.getKey());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
