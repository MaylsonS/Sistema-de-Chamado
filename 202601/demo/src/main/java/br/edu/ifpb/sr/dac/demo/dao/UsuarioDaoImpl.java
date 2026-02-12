package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public void save(Usuario usuario) {
        System.out.println("Salvou");
    }
}
