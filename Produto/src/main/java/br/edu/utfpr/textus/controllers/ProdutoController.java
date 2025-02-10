package br.edu.utfpr.textus.controllers;

import br.edu.utfpr.textus.dts.ProdutoDTO;
import br.edu.utfpr.textus.models.Produto;
import br.edu.utfpr.textus.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping()
    public ResponseEntity<List<Produto>> todosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> filtrarProduto(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Produto> criarProduto(@Validated(Produto.Create.class) @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO.nome(), produtoDTO.descricao(), produtoDTO.preco(), produtoDTO.estoque(), produtoDTO.imagem());

        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<Produto> editarProduto(@PathVariable Long id, @Validated(Produto.Update.class) @RequestBody ProdutoDTO produtoDTO) {

        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não Encontrado!"));

        if (produtoDTO.nome() != null) {
            produto.setNome(produtoDTO.nome());
        }
        if (produtoDTO.descricao() != null) {
            produto.setDescricao(produtoDTO.descricao());
        }
        if (produtoDTO.preco() != 0) {
            produto.setPreco(produtoDTO.preco());
        }
        if (produtoDTO.estoque() != 0) {
            produto.setEstoque(produtoDTO.estoque());
        }
        if (produtoDTO.imagem() != null){
            produto.setImagem(produtoDTO.imagem());
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
    }
}
