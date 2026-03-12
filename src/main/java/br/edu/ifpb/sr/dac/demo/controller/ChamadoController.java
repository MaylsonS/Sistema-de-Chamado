package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadoDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<String> criarChamado(@Valid @RequestBody PostChamadoDTO dto) {
        chamadoService.criarChamado(dto);
        return ResponseEntity.ok("Chamado criado ");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<GetChamadoDTO>> listarChamados(@PathVariable Long id, @PageableDefault(size = 10)Pageable page) {
        return ResponseEntity.ok(chamadoService.listarChamadosDoUsuario(id,page));
    }
}