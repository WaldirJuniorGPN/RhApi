package br.com.mundo.RHApi.modelos.calculadora;

import br.com.mundo.RHApi.modelos.atendente.Atendente;

import java.math.BigDecimal;
import java.util.List;

public class SonhoPercentuaisDaCalculadoraGratificacao extends CalculadoraGratificacao {

    private static final Double PRIMEIRO_COLOCADO = 0.012;
    private static final Double SEGUNDO_COLOCADO = 0.008;
    private static final Double TERCEIRO_COLOCADO = 0.004;
    private static final Double DEMAIS_COLOCADOS = 0.002;


    public void calcular(List<Atendente> lista) {
        super.calcularGratificacao(lista, BigDecimal.valueOf(PRIMEIRO_COLOCADO), BigDecimal.valueOf(SEGUNDO_COLOCADO), BigDecimal.valueOf(TERCEIRO_COLOCADO), BigDecimal.valueOf(DEMAIS_COLOCADOS));
    }

}
