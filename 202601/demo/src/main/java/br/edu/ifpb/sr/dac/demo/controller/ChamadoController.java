package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadoDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    public ResponseEntity<String> criarChamado(@RequestBody PostChamadoDTO dto) {
        chamadoService.criarChamado(dto);
        return ResponseEntity.ok("Chamado criado ");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GetChamadoDTO>> listarChamados(@PathVariable Long id) {
        return ResponseEntity.ok(chamadoService.listarChamadosDoUsuario(id));
    }
}