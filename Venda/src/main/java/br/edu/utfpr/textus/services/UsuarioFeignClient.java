package br.edu.utfpr.textus.services;

import org.springframework.cloud.openfeign.FeignClient;
import br.edu.utfpr.textus.models.Usuario;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="api-usuario", url="http://localhost:8080")
public interface UsuarioFeignClient {

    @GetMapping("/usuarios/{id}")
    Usuario getUsuarioById(@PathVariable(name = "id") Long id);

}