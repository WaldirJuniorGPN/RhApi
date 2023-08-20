ALTER TABLE funcionarios
ADD COLUMN vendas_semanais_id BIGINT,
ADD FOREIGN KEY (vendas_semanais_id) REFERENCES vendas_semanais(id);
