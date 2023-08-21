package br.com.mundo.RHApi.repository;

import br.com.mundo.RHApi.model.Calculadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {
}
