package br.edu.ifpb.sr.dac.demo.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String username;
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
