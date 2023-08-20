CREATE TABLE vendas_semanais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vendasPrimeiraSemana DECIMAL(19, 2),
    vendasSegundaSemana DECIMAL(19, 2),
    vendasTerceiraSemana DECIMAL(19, 2),
    vendasQuartaSemana DECIMAL(19, 2),
    vendasQuintaSemana DECIMAL(19, 2),
    vendasSextaSemana DECIMAL(19, 2),
    id_funcionario BIGINT,
    FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);