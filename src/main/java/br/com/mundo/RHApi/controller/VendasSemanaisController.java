package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoVendasSemanais;
import br.com.mundo.RHApi.dto.request.DadosCadastroVendasSemanais;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoVendasSemanais;
import br.com.mundo.RHApi.dto.response.DadosListagemVendasSemanais;
import br.com.mundo.RHApi.model.VendasSemanais;
import br.com.mundo.RHApi.repository.VendasSemanaisRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("vendas")
public class VendasSemanaisController {

    @Autowired
    private VendasSemanaisRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVendasSemanais dados, UriComponentsBuilder uriBuilder) {
        var vendasSemanais = new VendasSemanais(dados);
        repository.save(vendasSemanais);
        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(vendasSemanais.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVendasSemanais(vendasSemanais));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemVendasSemanais>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemVendasSemanais::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoVendasSemanais dados) {
        var vendasSemanais = repository.getReferenceById(dados.id());
        vendasSemanais.atualizacaoVendas(dados);
        return ResponseEntity.ok(new DadosDetalhamentoVendasSemanais(vendasSemanais));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
