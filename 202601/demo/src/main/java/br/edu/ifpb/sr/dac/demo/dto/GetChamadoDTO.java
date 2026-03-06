package br.edu.ifpb.sr.dac.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GetChamadoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String status;
    private String nomeUsuario;
    private LocalDateTime dataAbertura;
}