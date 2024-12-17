package br.edu.utfpr.textus.controllers;

import br.edu.utfpr.textus.dts.UsuarioDTO;
import br.edu.utfpr.textus.models.Usuario;
import br.edu.utfpr.textus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> criarUsuario(@Validated(Usuario.Create.class) @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.nome(), usuarioDTO.senha());

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(@Validated(Usuario.Login.class) @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.login(usuarioDTO.nome(), usuarioDTO.senha()).orElseThrow(() -> new RuntimeException("Usuario não Encontrado!"));

        return ResponseEntity.status(HttpStatus.OK).body(usuario.getId());
    }

}
