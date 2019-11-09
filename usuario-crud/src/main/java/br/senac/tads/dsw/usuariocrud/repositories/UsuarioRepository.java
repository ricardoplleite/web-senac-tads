package br.senac.tads.dsw.usuariocrud.repositories;

import br.senac.tads.dsw.usuariocrud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
