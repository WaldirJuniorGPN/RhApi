CREATE TABLE funcionarios (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    loja VARCHAR(255) NOT NULL,
    gratificacao DECIMAL(10,2),
    vendas DECIMAL(10,2),
    tipo_funcionario VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)

);