package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    @Transactional
    public void save(PostUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setUsername(dto.username());
        this.usuarioDao.save(usuario);
    }

    @Override
    public List<GetUsuariosRespDTO> listAll() {
        return this.usuarioDao.
                findAll().
                stream().
                map(usuario -> new GetUsuariosRespDTO(usuario.getId(), usuario.getNome(), usuario.getUsername())).
                toList();
    }
}
