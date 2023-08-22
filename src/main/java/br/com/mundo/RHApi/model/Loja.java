package br.com.mundo.RHApi.model;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoLoja;
import br.com.mundo.RHApi.dto.request.DadosCadastroLoja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Loja")
@Table(name = "lojas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Atendente> atendentes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calculadora_id")
    private Calculadora calculadora;

    public Loja(DadosCadastroLoja dados) {
        this.nome = dados.nome();
        this.calculadora = dados.calculadora();
    }

    public void atualizarDados(DadosAtualizacaoLoja dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.calculadora() != null) {
            this.calculadora = dados.calculadora();
        }
    }
}
