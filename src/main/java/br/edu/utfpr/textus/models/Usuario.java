package br.edu.utfpr.textus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    public interface Create { }
    public interface Update { }
    public interface Login { }

    public Usuario (){}

    public Usuario (String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    long id;

    @NotBlank(message = "O Campo 'nome' não pode estar vazio!", groups = {Usuario.Create.class, Usuario.Login.class})
    @Size(min = 3, max = 100, message = "O Campo 'nome' deve ter no mínimo 3 e no máximo 100 caracteres!", groups = {Usuario.Create.class, Usuario.Update.class, Usuario.Login.class})
    String nome;

    @NotBlank(message = "O Campo 'descricao' não pode estar vazio!", groups = {Usuario.Create.class, Usuario.Login.class})
    @Size(min = 3, max = 300, message = "O Campo 'descricao' deve ter no mínimo 8 e no máximo 16 caracteres!", groups = {Usuario.Create.class, Usuario.Update.class, Usuario.Login.class})
    String senha;

}
