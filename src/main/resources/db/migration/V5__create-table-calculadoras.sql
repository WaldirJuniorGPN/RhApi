CREATE TABLE calculadoras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    percentual_primeiro_colocado DOUBLE,
    percentual_segundo_colocado DOUBLE,
    percentual_terceiro_colocado DOUBLE,
    percentual_demais_colocados DOUBLE,
    loja_id BIGINT,
    FOREIGN KEY (loja_id) REFERENCES lojas(id)
);
