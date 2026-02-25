package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.Getusuario;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.model.Usuario;

import java.util.List;

public interface UsuarioService {
    void save(PostUsuarioDTO dto);
    List<Getusuario> listar();
}
