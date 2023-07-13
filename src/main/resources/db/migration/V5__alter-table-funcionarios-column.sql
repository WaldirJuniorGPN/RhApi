-- Renomear colunas da tabela 'funcionarios'
ALTER TABLE funcionarios
  CHANGE COLUMN vendaPrimeiraSemana venda_primeira_semana DECIMAL(10,2),
  CHANGE COLUMN vendaSegundaSemana venda_segunda_semana DECIMAL(10,2),
  CHANGE COLUMN vendaTerceiraSemana venda_terceira_semana DECIMAL(10,2),
  CHANGE COLUMN vendaQuartaSemana venda_quarta_semana DECIMAL(10,2),
  CHANGE COLUMN vendaQuintaSemana venda_quinta_semana DECIMAL(10,2),
  CHANGE COLUMN vendaTotal venda_total DECIMAL(10,2),
  CHANGE COLUMN gratificacaoPrimeiraSemana gratificacao_primeira_semana DECIMAL(10,2),
  CHANGE COLUMN gratificacaoSegundaSemana gratificacao_segunda_semana DECIMAL(10,2),
  CHANGE COLUMN gratificacaoTerceiraSemana gratificacao_terceira_semana DECIMAL(10,2),
  CHANGE COLUMN gratificacaoQuartaSemana gratificacao_quarta_semana DECIMAL(10,2),
  CHANGE COLUMN gratificacaoQuintaSemana gratificacao_quinta_semana DECIMAL(10,2),
  CHANGE COLUMN gratificacaoTotal gratificacao_total DECIMAL(10,2);
