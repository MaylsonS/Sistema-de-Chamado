package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostChamadoDTO {
    @NotBlank(message = "Campo de Titulo obrigatório !!")
    @Size(min = 10, max = 50)
    private String titulo;
    @NotBlank(message = "Campo de Descrição obrigatório !!")
    @Size(min = 10, max = 500)
    private String descricao;
    private String status;
    @NotNull(message = "Campo é obrigatório associar a um usuario !!")
    private Long usuarioId;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }
}