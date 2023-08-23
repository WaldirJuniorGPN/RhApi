ALTER TABLE vendas_semanais
CHANGE COLUMN vendasPrimeiraSemana vendas_primeira_semana DECIMAL(19, 2),
CHANGE COLUMN vendasSegundaSemana vendas_segunda_semana DECIMAL(19, 2),
CHANGE COLUMN vendasTerceiraSemana vendas_terceira_semana DECIMAL(19, 2),
CHANGE COLUMN vendasQuartaSemana vendas_quarta_semana DECIMAL(19, 2),
CHANGE COLUMN vendasQuintaSemana vendas_quinta_semana DECIMAL(19, 2),
CHANGE COLUMN vendasSextaSemana vendas_sexta_semana DECIMAL(19, 2),
CHANGE COLUMN id_funcionario funcionario_id BIGINT;
