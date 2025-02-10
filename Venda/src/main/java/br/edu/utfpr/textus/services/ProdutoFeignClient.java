package br.edu.utfpr.textus.services;

import org.springframework.cloud.openfeign.FeignClient;
import br.edu.utfpr.textus.models.Produto;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="api-produto", url="http://localhost:8080")
public interface ProdutoFeignClient {

    @GetMapping("/produtos/{id}")
    Produto getProdutoById(@PathVariable(name = "id") Long id);

    @PostMapping("/produtos/editar/{id}")
    Produto atualizarEstoque(@PathVariable(name = "id") Long id, @RequestBody Produto produto);

}