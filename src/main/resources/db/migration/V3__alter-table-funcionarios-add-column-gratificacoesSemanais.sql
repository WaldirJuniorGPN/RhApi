ALTER TABLE funcionarios
ADD vendaPrimeiraSemana DECIMAL(10,2) NULL,
ADD vendaSegundaSemana DECIMAL(10,2) NULL,
ADD vendaTerceiraSemana DECIMAL(10,2) NULL,
ADD vendaQuartaSemana DECIMAL(10,2) NULL,
ADD vendaQuintaSemana DECIMAL(10,2) NULL,
ADD gratificacaoPrimeiraSemana DECIMAL(10,2) NULL,
ADD gratificacaoSegundaSemana DECIMAL(10,2) NULL,
ADD gratificacaoTerceiraSemana DECIMAL(10,2) NULL,
ADD gratificacaoQuartaSemana DECIMAL(10,2) NULL,
ADD gratificacaoQuintaSemana DECIMAL(10,2) NULL;

ALTER TABLE funcionarios
CHANGE vendas vendaTotal DECIMAL(10,2) NULL,
CHANGE gratificacao gratificacaoTotal DECIMAL(10,2) NULL;

