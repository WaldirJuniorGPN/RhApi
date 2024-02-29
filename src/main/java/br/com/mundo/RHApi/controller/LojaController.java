package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoLoja;
import br.com.mundo.RHApi.dto.request.DadosCadastroLoja;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoLoja;
import br.com.mundo.RHApi.dto.response.DadosListagemLoja;
import br.com.mundo.RHApi.model.Loja;
import br.com.mundo.RHApi.repository.LojaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLoja> cadastrar(@RequestBody @Valid DadosCadastroLoja dados, UriComponentsBuilder uriComponentsBuilder) {

        var loja = new Loja(dados);
        this.lojaRepository.save(loja);
        var uri = uriComponentsBuilder.path("/loja/{id}").buildAndExpand(loja.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLoja(loja));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLoja>> listar(Pageable paginacao) {
        var page = lojaRepository.findAll(paginacao).map(DadosListagemLoja::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLoja> atualizar(@RequestBody @Valid DadosAtualizacaoLoja dados) {
        var loja = lojaRepository.getReferenceById(dados.id());
        loja.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLoja(loja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lojaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
