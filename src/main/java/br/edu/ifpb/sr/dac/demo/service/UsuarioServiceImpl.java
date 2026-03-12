package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper) {
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional
    public void save(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setTipo("USUARIO");
        this.usuarioDao.save(usuario);
    }


    @Transactional
    public void saveAdmin(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setTipo("ADMIN");


        usuarioDao.save(usuario);
    }

    @Override
    public List<GetUsuariosRespDTO> listAll() {
        return this.usuarioDao.findAll().stream().map(usuario -> new GetUsuariosRespDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo(), usuario.getCpf())).toList();
    }


    @Override
    public Page<GetUsuariosRespDTO> listAllAdmin(/*@PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC)*/Pageable page) {
        Page<Usuario> usuarioPage = this.usuarioDao.findAllByTipo("ADMIN",page);
        return usuarioPage.map(this.usuarioMapper::toDto);
}



}
