package br.com.mundo.RHApi.modelos.calculadora;

import br.com.mundo.RHApi.modelos.atendente.Atendente;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ListasDeFuncionarios {

    private static List<Atendente> listaMundo = new ArrayList<>();
    private static List<Atendente> listaLapis = new ArrayList<>();
    private static List<Atendente> listaSonho = new ArrayList<>();
    private static List<Atendente> listaVovo = new ArrayList<>();
    private static List<Atendente> listaTodosOsFuncionarios = new ArrayList<>();

    public ListasDeFuncionarios() {
    }

    public ListasDeFuncionarios(List<Atendente> listaAtendentes) {
        this.atribuirAtendente(listaAtendentes);
    }

    private void atribuirAtendente(List<Atendente> listaAtendentes) {
        listaAtendentes.forEach(atendente -> {
            switch (atendente.getLoja()) {
                case MUNDO:
                    ListasDeFuncionarios.listaMundo.add(atendente);
                    break;
                case SONHO:
                    ListasDeFuncionarios.listaSonho.add(atendente);
                    break;
                case VOVO:
                    ListasDeFuncionarios.listaVovo.add(atendente);
                    break;
                case LAPIS:
                    ListasDeFuncionarios.listaLapis.add(atendente);
                    break;
            }
        });
    }

    public void adicionar(List<Atendente> listaTodos) {
        new ListasDeFuncionarios(listaTodos);
    }

    public List<Atendente> calcularGratificacoes() {

        if (!listaMundo.isEmpty()) {
            new MundoPercentuaisDaCalculadoraGratificacao().calcular(listaMundo);
        }
        if (!listaLapis.isEmpty()) {
            new LapisPercentuaisDaCalculadoraGratificacao().calcular(listaLapis);
        }
        if (!listaSonho.isEmpty()) {
            new SonhoPercentuaisDaCalculadoraGratificacao().calcular(listaSonho);
        }
        if (!listaVovo.isEmpty()) {
            new VovoPercentuaisDaCalculadoraGratificacao().calcular(listaVovo);
        }


        ListasDeFuncionarios.listaTodosOsFuncionarios.addAll(ListasDeFuncionarios.listaMundo);
        ListasDeFuncionarios.listaTodosOsFuncionarios.addAll(ListasDeFuncionarios.listaSonho);
        ListasDeFuncionarios.listaTodosOsFuncionarios.addAll(ListasDeFuncionarios.listaVovo);
        ListasDeFuncionarios.listaTodosOsFuncionarios.addAll(ListasDeFuncionarios.listaLapis);

        return ListasDeFuncionarios.listaTodosOsFuncionarios;
    }

}
