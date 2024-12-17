package br.edu.utfpr.textus.controllers;

import br.edu.utfpr.textus.dts.VendaDTO;
import br.edu.utfpr.textus.models.Produto;
import br.edu.utfpr.textus.models.Usuario;
import br.edu.utfpr.textus.models.Venda;
import br.edu.utfpr.textus.repository.ProdutoRepository;
import br.edu.utfpr.textus.repository.UsuarioRepository;
import br.edu.utfpr.textus.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Venda> criarVenda(@Validated(Venda.Create.class) @RequestBody VendaDTO vendaDTO) {

        Produto produto = produtoRepository.findById(vendaDTO.produto()).orElseThrow(() -> new RuntimeException("Produto não Encontrado!"));

        Usuario usuario = usuarioRepository.findById(vendaDTO.usuario()).orElseThrow(() -> new RuntimeException("Usuario Invalido!"));

        if (produto.getEstoque() < vendaDTO.quantidade()) {
            throw new RuntimeException("Estoque Insuficiente!");
        } else {
            produto.setEstoque(produto.getEstoque() - vendaDTO.quantidade());

            produtoRepository.save(produto);

            Venda venda = new Venda(produto, usuario, vendaDTO.quantidade());

            return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.save(venda));
        }
    }
}
