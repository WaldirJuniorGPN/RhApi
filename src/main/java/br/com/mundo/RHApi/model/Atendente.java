package br.com.mundo.RHApi.model;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoAtendente;
import br.com.mundo.RHApi.dto.request.DadosCadastroAtendente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Atendente")
@Table(name = "atendentes")
@Getter
@EqualsAndHashCode(of = "id")
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String loja;
    private final List<BigDecimal> vendas = new ArrayList<BigDecimal>(6);

    public Atendente(DadosCadastroAtendente dados) {
        this.nome = dados.nome();
        this.loja = dados.loja();
    }

    public void atualizar(DadosAtualizacaoAtendente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.loja() != null) {
            this.loja = dados.loja();
        }
    }
}
