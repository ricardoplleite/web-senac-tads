package br.senac.tads.dsw.usuariocrud.services;

import br.senac.tads.dsw.usuariocrud.entity.Usuario;
import br.senac.tads.dsw.usuariocrud.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository repository;

    @Autowired
    private EntityManager em;

    @Transactional
    public List<Usuario> listar(){
        List<Usuario> listarUsuarios = repository.findAll();

        return listarUsuarios;
    }

    @Transactional
    public void salvar(Usuario usuario) {

            LocalDateTime dataHora = LocalDateTime.now();
            usuario.setDataHoraCadastro(dataHora);

            if (usuario.getId() == null) {
                em.persist(usuario);

            } else {
                em.merge(usuario);
        }
    }

    public Usuario get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
