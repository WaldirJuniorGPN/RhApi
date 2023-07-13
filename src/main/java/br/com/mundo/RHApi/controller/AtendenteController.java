package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.modelos.atendente.*;
import br.com.mundo.RHApi.modelos.calculadora.ListasDeFuncionarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendentes")
public class AtendenteController {

    private final AtendenteRepository repository;
    private final ListasDeFuncionarios listasDeFuncionarios;

    @Autowired
    public AtendenteController(AtendenteRepository repository, ListasDeFuncionarios listasDeFuncionarios) {
        this.repository = repository;
        this.listasDeFuncionarios = listasDeFuncionarios;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAtendente dados) {
        repository.save(new Atendente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarAtendente dados) {
        var atendente = repository.getReferenceById(dados.id());
        atendente.atualizarInformacao(dados);
    }

    @PutMapping("/atualizarGratificacao")
    @Transactional
    public void atualizarGratificacao() {
        listasDeFuncionarios.adicionar(repository.findAllByAtivoTrue());
        new Atendente().atualizarInformacao(listasDeFuncionarios.calcularGratificacoes());
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
