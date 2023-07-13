-- Alterar a ordem das colunas
ALTER TABLE funcionarios MODIFY COLUMN vendaPrimeiraSemana decimal(10,2) AFTER ativo;
ALTER TABLE funcionarios MODIFY COLUMN vendaSegundaSemana decimal(10,2) AFTER vendaPrimeiraSemana;
ALTER TABLE funcionarios MODIFY COLUMN vendaTerceiraSemana decimal(10,2) AFTER vendaSegundaSemana;
ALTER TABLE funcionarios MODIFY COLUMN vendaQuartaSemana decimal(10,2) AFTER vendaTerceiraSemana;
ALTER TABLE funcionarios MODIFY COLUMN vendaQuintaSemana decimal(10,2) AFTER vendaQuartaSemana;
ALTER TABLE funcionarios MODIFY COLUMN vendaTotal decimal(10,2) AFTER vendaQuintaSemana;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoPrimeiraSemana decimal(10,2) AFTER vendaTotal;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoSegundaSemana decimal(10,2) AFTER gratificacaoPrimeiraSemana;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoTerceiraSemana decimal(10,2) AFTER gratificacaoSegundaSemana;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoQuartaSemana decimal(10,2) AFTER gratificacaoTerceiraSemana;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoQuintaSemana decimal(10,2) AFTER gratificacaoQuartaSemana;
ALTER TABLE funcionarios MODIFY COLUMN gratificacaoTotal decimal(10,2) AFTER gratificacaoQuintaSemana;
