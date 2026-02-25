package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Boolean> postUsuario(@RequestBody PostUsuarioDTO dto) {
        this.usuarioService.save(dto);
        return ResponseEntity.created(URI.create("/1")).body(Boolean.TRUE);
    }

    @GetMapping
    public ResponseEntity<List<GetUsuariosRespDTO>> getAllUsuarios() {
        return ResponseEntity.ok(this.usuarioService.listAll());
    }
}
