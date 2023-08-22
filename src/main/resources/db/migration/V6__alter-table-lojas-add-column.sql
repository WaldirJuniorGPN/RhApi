ALTER TABLE lojas
ADD COLUMN calculadora_id BIGINT,
ADD CONSTRAINT fk_loja_calculadora
    FOREIGN KEY (calculadora_id) REFERENCES calculadoras(id);
