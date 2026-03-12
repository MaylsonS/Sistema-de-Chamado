package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByTipo(String tipo, Pageable page);
}
