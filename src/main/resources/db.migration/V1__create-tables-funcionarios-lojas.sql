
CREATE TABLE funcionarios (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255),
    salario decimal(19,2),
    tipo_funcionario varchar(255),
    gratificacao decimal(19,2),
    loja_id bigint
);

-- Tabela para a classe Loja
CREATE TABLE lojas (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255)
);

-- Chaves estrangeiras
ALTER TABLE funcionarios ADD FOREIGN KEY (loja_id) REFERENCES lojas(id);
