package br.edu.utfpr.textus.repository;

import br.edu.utfpr.textus.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuarios WHERE nome = :nome AND senha = :senha LIMIT 1", nativeQuery = true)
    Optional<Usuario> login(@Param("nome") String nome, @Param("senha") String senha);
}
