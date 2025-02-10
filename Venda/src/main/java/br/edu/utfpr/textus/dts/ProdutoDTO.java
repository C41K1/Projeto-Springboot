package br.edu.utfpr.textus.dts;

import br.edu.utfpr.textus.models.Produto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

public record ProdutoDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
        @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
        long id,

        @NotBlank(message = "O Campo 'nome' não pode estar vazio!", groups = Produto.Create.class)
        @Size(min = 3, max = 100, message = "O Campo 'nome' deve ter no mínimo 3 e no máximo 100 caracteres!", groups = {Produto.Create.class, Produto.Update.class})
        String nome,

        @NotBlank(message = "O Campo 'descricao' não pode estar vazio!", groups = Produto.Create.class)
        @Size(min = 3, max = 300, message = "O Campo 'descricao' deve ter no mínimo 3 e no máximo 300 caracteres!", groups = {Produto.Create.class, Produto.Update.class})
        String descricao,

        @NotNull(message = "O Campo 'preco' não pode estar vazio!", groups = Produto.Create.class)
        @PositiveOrZero(message = "O Campo 'preco' deve ser um numero positivo!", groups = {Produto.Create.class, Produto.Update.class})
        double preco,

        @NotNull(message = "O Campo 'estoque' não pode estar vazio!", groups = Produto.Create.class)
        @PositiveOrZero(message = "O Campo 'estoque' deve ser um numero positivo!", groups = {Produto.Create.class, Produto.Update.class})
        int estoque,

        @URL(message = "O Campo 'imagem' deve ser um Url!")
        String imagem
) { }
