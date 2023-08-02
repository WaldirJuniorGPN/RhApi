package br.com.mundo.RHApi.modelos.atendente;

import br.com.mundo.RHApi.modelos.dto.DadosAtualizarAtendente;
import br.com.mundo.RHApi.modelos.dto.DadosAtualizarVendasAtendente;
import br.com.mundo.RHApi.modelos.dto.DadosCadastroAtendente;
import br.com.mundo.RHApi.modelos.Funcionario;
import br.com.mundo.RHApi.modelos.calculadora.ListasDeFuncionarios;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue("atendente")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Atendente extends Funcionario {
    private BigDecimal vendaPrimeiraSemana = BigDecimal.ZERO;
    private BigDecimal vendaSegundaSemana = BigDecimal.ZERO;
    private BigDecimal vendaTerceiraSemana = BigDecimal.ZERO;
    private BigDecimal vendaQuartaSemana = BigDecimal.ZERO;
    private BigDecimal vendaQuintaSemana = BigDecimal.ZERO;
    private BigDecimal vendaSextaSemana = BigDecimal.ZERO;
    private BigDecimal vendaTotal = BigDecimal.ZERO;

    private BigDecimal gratificacaoPrimeiraSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoSegundaSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoTerceiraSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoQuartaSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoQuintaSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoSextaSemana = BigDecimal.ZERO;
    private BigDecimal gratificacaoTotal = BigDecimal.ZERO;

    @Setter(AccessLevel.NONE)
    private Boolean ativo;

    @Transient
    @Autowired
    private ListasDeFuncionarios listasDeFuncionarios;


    public Atendente(DadosCadastroAtendente dados) {
        this.ativo = true;
        super.setNome(dados.nome());
        super.setSalario(new BigDecimal(String.valueOf(dados.salario())));
        super.setLoja(dados.loja());
    }

    public void atualizarInformacao(DadosAtualizarAtendente dados) {
        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.loja() != null) {
            super.setLoja(dados.loja());
        }
        if (dados.salario() != null) {
            super.setSalario(new BigDecimal(String.valueOf(dados.salario())));
        }
        if (dados.vendasPrimeiraSemana() != null) {
            this.setVendaPrimeiraSemana(new BigDecimal(String.valueOf(dados.vendasPrimeiraSemana())));
        }
        if (dados.vendasSegundaSemana() != null) {
            this.setVendaSegundaSemana(new BigDecimal(String.valueOf(dados.vendasSegundaSemana())));
        }
        if (dados.vendasTerceiraSemana() != null) {
            this.setVendaTerceiraSemana(new BigDecimal(String.valueOf(dados.vendasTerceiraSemana())));
        }
        if (dados.vendasQuartaSemana() != null) {
            this.setVendaQuartaSemana(new BigDecimal(String.valueOf(dados.vendasQuartaSemana())));
        }
        if (dados.vendasQuintaSemana() != null) {
            this.setVendaQuintaSemana(new BigDecimal(String.valueOf(dados.vendasQuintaSemana())));
        }
        if (dados.vendasSextaSemana() != null) {
            this.setVendaSextaSemana(new BigDecimal(String.valueOf(dados.vendasSextaSemana())));
        }
    }

    public void atualizarInformacao(DadosAtualizarVendasAtendente dados) {
        if (dados.vendasPrimeiraSemana() != null) {
            this.setVendaPrimeiraSemana(new BigDecimal(String.valueOf(dados.vendasPrimeiraSemana())));
        }
        if (dados.vendasSegundaSemana() != null) {
            this.setVendaSegundaSemana(new BigDecimal(String.valueOf(dados.vendasSegundaSemana())));
        }
        if (dados.vendasTerceiraSemana() != null) {
            this.setVendaTerceiraSemana(new BigDecimal(String.valueOf(dados.vendasTerceiraSemana())));
        }
        if (dados.vendasQuartaSemana() != null) {
            this.setVendaQuartaSemana(new BigDecimal(String.valueOf(dados.vendasQuartaSemana())));
        }
        if (dados.vendasQuintaSemana() != null) {
            this.setVendaQuintaSemana(new BigDecimal(String.valueOf(dados.vendasQuintaSemana())));
        }
        if (dados.vendasSextaSemana() != null) {
            this.setVendaSextaSemana(new BigDecimal(String.valueOf(dados.vendasSextaSemana())));
        }
        calcularVendaTotal();
    }

    private void calcularVendaTotal() {
        BigDecimal vendaTotal = BigDecimal.ZERO;
        vendaTotal = vendaTotal.add(getVendaPrimeiraSemana())
                .add(getVendaSegundaSemana())
                .add(getVendaTerceiraSemana())
                .add(getVendaQuartaSemana())
                .add(getVendaQuintaSemana())
                .add(getVendaSextaSemana());

        this.setVendaTotal(vendaTotal);
    }


    @Override
    public void desativar() {
        this.ativo = false;
    }


    public void setGratificacaoTotal(BigDecimal gratificacao) {

        this.gratificacaoTotal = gratificacao;
    }

}


