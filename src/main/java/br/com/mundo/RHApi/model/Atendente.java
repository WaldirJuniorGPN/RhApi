package br.com.mundo.RHApi.model;


import br.com.mundo.RHApi.dto.request.DadosAtualizacaoAtendente;
import br.com.mundo.RHApi.dto.request.DadosCadastroAtedente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Atendente")
@DiscriminatorValue("atendente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Atendente extends Funcionario {

    private BigDecimal gratificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;

    public Atendente(DadosCadastroAtedente dados) {
        super.setNome(dados.nome());
        super.setSalario(dados.salario());
        this.loja = dados.loja();
    }

    public void atualizarAtendente(DadosAtualizacaoAtendente dados) {
        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.salario() != null) {
            super.setSalario(dados.salario());
        }
        if (dados.loja() != null) {
            this.loja = dados.loja();
        }
    }
}
