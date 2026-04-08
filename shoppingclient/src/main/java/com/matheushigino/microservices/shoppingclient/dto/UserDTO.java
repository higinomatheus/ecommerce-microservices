package com.matheushigino.microservices.shoppingclient.dto;

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
    private String nome;
    private String cpf;
    private String endereco;
    private String key;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
