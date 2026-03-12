package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/adm")
public class AdmController {

    private final UsuarioService usuarioService;

    public AdmController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Boolean> postAdm( @Valid @RequestBody PostUsuarioDTO dto) {

        this.usuarioService.saveAdmin(dto);
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping
    public ResponseEntity<Page<GetUsuariosRespDTO>> getAdms(@PageableDefault(size = 10) Pageable page) {
        return ResponseEntity.ok(this.usuarioService.listAllAdmin(page));
    }

}
