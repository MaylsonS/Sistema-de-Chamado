package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.ChamadoDao;
import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoMapper;
import br.edu.ifpb.sr.dac.demo.dto.GetChamadoDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    private final ChamadoDao chamadoDao;
    private final UsuarioDao usuarioDao;
    private final ChamadoMapper chamadoMapper;

    public ChamadoService(ChamadoDao chamadoDao, UsuarioDao usuarioDao, ChamadoMapper chamadoMapper) {
        this.chamadoDao = chamadoDao;
        this.usuarioDao = usuarioDao;
        this.chamadoMapper = chamadoMapper;
    }

    @Transactional
    public void criarChamado(PostChamadoDTO dto) {
        Usuario usuario = usuarioDao.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario != null) {
            Chamado chamado = new Chamado();
            chamado.setTitulo(dto.getTitulo());
            chamado.setDescricao(dto.getDescricao());
            chamado.setUsuario(usuario);
            chamadoDao.save(chamado);
        }


    }

    public Page<GetChamadoDTO> listarChamadosDoUsuario(Long usuarioId, Pageable page) {
        Page<Chamado> chamadoPage = chamadoDao.findAllByUsuario_Id(usuarioId, page);
        Page<GetChamadoDTO> resultado = chamadoPage.map(this.chamadoMapper::toDto);
        return resultado;
    }
}