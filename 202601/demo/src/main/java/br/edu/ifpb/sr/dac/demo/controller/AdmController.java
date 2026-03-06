package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adm")
public class AdmController {

    private final UsuarioService usuarioService;

    public AdmController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Boolean> postAdm(@RequestBody PostUsuarioDTO dto) {

        this.usuarioService.saveAdmin(dto);
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping
    public ResponseEntity<List<GetUsuariosRespDTO>> getAdms() {
        return ResponseEntity.ok(this.usuarioService.listAllAdmin());
    }

}
