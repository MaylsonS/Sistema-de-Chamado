package br.edu.ifpb.sr.dac.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.aspectj.bridge.IMessage;

public record PostUsuarioDTO(
        @NotBlank(message = "Campo de Nome obrigatório !!")
        @Size(min = 3, max = 50)
        String nome,
        @Email
        @NotBlank(message = "Campo de Email obrigatório !!")
        String email,
        @NotBlank(message = "Campo de Senha obrigatório !")
        @Size(min = 1, max = 50)
        String senha,
        @NotBlank(message = "Campo de Senha obrigatório !")
        @Size(min = 1, max = 50)
        String confirmacaoSenha,
        @NotBlank(message = "Campo de CPF obrigatorio !")
        @Size(min = 11, max =11)
        String cpf


) {}
