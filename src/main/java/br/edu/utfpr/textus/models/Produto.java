package br.edu.utfpr.textus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    public Produto(){}

    public interface Create { }
    public interface Update { }

    public Produto (String nome, String descricao, Double preco, Integer estoque, String imagem){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.imagem = imagem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
    private Long id;

    @NotBlank(message = "O Campo 'nome' não pode estar vazio!", groups = Create.class)
    @Size(min = 3, max = 100, message = "O Campo 'nome' deve ter no mínimo 3 e no máximo 100 caracteres!", groups = {Create.class, Update.class})
    private String nome;

    @NotBlank(message = "O Campo 'descricao' não pode estar vazio!", groups = Create.class)
    @Size(min = 3, max = 300, message = "O Campo 'descricao' deve ter no mínimo 3 e no máximo 300 caracteres!", groups = {Create.class, Update.class})
    private String descricao;

    @NotNull(message = "O Campo 'preco' não pode estar vazio!", groups = Create.class)
    @PositiveOrZero(message = "O Campo 'preco' deve ser um numero positivo!", groups = {Create.class, Update.class})
    private double preco;

    @NotNull(message = "O Campo 'estoque' não pode estar vazio!", groups = Create.class)
    @PositiveOrZero(message = "O Campo 'estoque' deve ser um numero positivo!", groups = {Create.class, Update.class})
    private int estoque;

    @URL(message = "O Campo 'imagem' deve ser um Url!")
    private String imagem;
}
