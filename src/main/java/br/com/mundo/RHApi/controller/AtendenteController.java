package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.modelos.dto.DadosAtualizarAtendente;
import br.com.mundo.RHApi.modelos.dto.DadosAtualizarVendasAtendente;
import br.com.mundo.RHApi.modelos.dto.DadosCadastroAtendente;
import br.com.mundo.RHApi.modelos.dto.DadosListagemAtendente;
import br.com.mundo.RHApi.modelos.atendente.*;
import br.com.mundo.RHApi.modelos.calculadora.ListasDeFuncionarios;
import br.com.mundo.RHApi.modelos.repository.AtendenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteRepository repository;

    @Autowired
    private ListasDeFuncionarios lista;

    @PostMapping("/cadastrar/funcionario")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAtendente dados) {
        repository.save(new Atendente(dados));
    }

    @PutMapping("/cadastrar/vendas")
    @Transactional
    public void cadastrarVendas(@RequestBody @Valid DadosAtualizarVendasAtendente dados) {
        var atendente = repository.getReferenceById(dados.id());
        atendente.atualizarInformacao(dados);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarAtendente dados) {
        var atendente = repository.getReferenceById(dados.id());
        atendente.atualizarInformacao(dados);
    }

    @PutMapping("/cadastrar/gratificacao")
    @Transactional
    public void atualizarGratificacao() {
        var todosAtendentes = repository.findAllByAtivoTrue();
        lista.adicionar(todosAtendentes);
        lista.calcularGratificacoes();

        repository.saveAll(todosAtendentes);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativar(@PathVariable Long id) {
        var atendente = repository.getReferenceById(id);
        atendente.desativar();
    }

    @GetMapping
    public Page<DadosListagemAtendente> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAtendente::new);
    }
}
