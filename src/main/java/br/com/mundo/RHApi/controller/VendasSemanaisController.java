package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosCadastroVendasSemanais;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoVendasSemanais;
import br.com.mundo.RHApi.model.VendasSemanais;
import br.com.mundo.RHApi.repository.VendasSemanaisRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("vendas")
public class VendasSemanaisController {

    @Autowired
    private VendasSemanaisRepository repository;

    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVendasSemanais dados, UriComponentsBuilder uriBuilder) {
        var vendasSemanais = new VendasSemanais(dados);
        repository.save(vendasSemanais);
        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(vendasSemanais.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVendasSemanais(vendasSemanais));
    }
}
