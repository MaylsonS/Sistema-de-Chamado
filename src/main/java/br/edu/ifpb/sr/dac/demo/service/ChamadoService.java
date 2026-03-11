package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.ChamadoDao;
import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetChamadoDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    private final ChamadoDao chamadoDao;
    private final UsuarioDao usuarioDao;

    public ChamadoService(ChamadoDao chamadoDao, UsuarioDao usuarioDao) {
        this.chamadoDao = chamadoDao;
        this.usuarioDao = usuarioDao;
    }

    @Transactional
    public void criarChamado(PostChamadoDTO dto) {
        Usuario usuario = usuarioDao.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario != null) {
            Chamado chamado = new Chamado();
            chamado.setTitulo(dto.getTitulo());
            chamado.setDescricao(dto.getDescricao());
            chamado.setUsuario(usuario);
            chamadoDao.save(chamado);
        }


    }

    public List<GetChamadoDTO> listarChamadosDoUsuario(Long usuarioId) {
        return chamadoDao.findAllByUsuarioId(usuarioId)
                .stream()
                .map(chamado -> {
                    GetChamadoDTO dto = new GetChamadoDTO();
                    dto.setId(chamado.getId());
                    dto.setTitulo(chamado.getTitulo());
                    dto.setDescricao(chamado.getDescricao());
                    dto.setStatus(chamado.getStatus());
                    dto.setNomeUsuario(chamado.getUsuario().getNome());
                    dto.setDataAbertura(chamado.getDataAbertura());
                    return dto;
                }).collect(Collectors.toList());
    }
}