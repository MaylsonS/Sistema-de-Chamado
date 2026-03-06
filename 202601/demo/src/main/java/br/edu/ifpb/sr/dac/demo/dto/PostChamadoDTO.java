package br.edu.ifpb.sr.dac.demo.dto;

import lombok.Data;

@Data
public class PostChamadoDTO {
    private String titulo;
    private String descricao;
    private Long usuarioId;
}