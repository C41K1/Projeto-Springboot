package br.edu.utfpr.textus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vendas")
public class Venda {

    public interface Create { }
    public interface Update { }

    public Venda(){}

    public Venda (Produto produto, Usuario usuario, int quantidade){
        this.produto = produto;
        this.usuario = usuario;
        this.quantidade = quantidade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotNull(message = "O Campo 'quantidade' não pode estar vazio!", groups = Produto.Create.class)
    @Positive(message = "O Campo 'quantidade' deve ser um numero positivo!", groups = {Produto.Create.class, Produto.Update.class})
    private int quantidade;

}
