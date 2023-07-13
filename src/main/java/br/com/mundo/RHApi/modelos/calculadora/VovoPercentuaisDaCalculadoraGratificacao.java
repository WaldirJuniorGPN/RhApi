package br.com.mundo.RHApi.modelos.calculadora;

import br.com.mundo.RHApi.modelos.atendente.Atendente;

import java.math.BigDecimal;
import java.util.List;

public class VovoPercentuaisDaCalculadoraGratificacao extends CalculadoraGratificacao {

    private static final Double PRIMEIRO_COLOCADO = 0.010;
    private static final Double SEGUNDO_COLOCADO = 0.005;
    private static final Double TERCEIRO_COLOCADO = 0.002;
    private static final Double DEMAIS_COLOCADOS = 0.000;


    public List<Atendente> calcular(List<Atendente> lista) {
        return super.calcularGratificacao(lista, BigDecimal.valueOf(PRIMEIRO_COLOCADO), BigDecimal.valueOf(SEGUNDO_COLOCADO), BigDecimal.valueOf(TERCEIRO_COLOCADO), BigDecimal.valueOf(DEMAIS_COLOCADOS));
    }

}
