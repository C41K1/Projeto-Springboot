package br.edu.utfpr.textus.dts;

import br.edu.utfpr.textus.models.Produto;
import br.edu.utfpr.textus.models.Venda;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VendaDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
        @SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", allocationSize = 1)
        long id,

        @NotNull(message = "O Campo 'produto' não pode estar vazio!", groups = Venda.Create.class)
        long produto,

        @NotNull(message = "O Campo 'usuario' não pode estar vazio!", groups = Venda.Create.class)
        long usuario,

        @NotNull(message = "O Campo 'quantidade' não pode estar vazio!", groups = Venda.Create.class)
        @Positive(message = "O Campo 'quantidade' deve ser um numero positivo!", groups = {Venda.Create.class, Venda.Update.class})
        int quantidade
) {
}
