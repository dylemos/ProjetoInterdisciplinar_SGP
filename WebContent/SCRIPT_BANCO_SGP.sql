CREATE TABLE USERADMIN(
ID_ADM INTEGER AUTO_INCREMENT,
STATUS VARCHAR(7),
NOME VARCHAR(60) NOT NULL,
CPF VARCHAR(14)NOT NULL UNIQUE,
LOGIN VARCHAR(15) NOT NULL UNIQUE,
SENHA VARCHAR(30) NOT NULL,
CONSTRAINT PK_ID_ADM PRIMARY KEY(ID_ADM)
);

CREATE TABLE PLANO(
IDPLANO INT AUTO_INCREMENT,
NOME VARCHAR(20) NOT NULL UNIQUE,
UPLOAD INT NOT NULL,
DOWNLOAD INT NOT NULL,
VALOR DOUBLE NOT NULL,
CONSTRAINT PK_IDPLANO PRIMARY KEY(IDPLANO)
);

CREATE TABLE CLIENTE(
ID_CLIENTE INTEGER AUTO_INCREMENT,
STATUS VARCHAR(7), 
NOME VARCHAR(60) NOT NULL,
RG VARCHAR(15) UNIQUE,
CPF VARCHAR(14) NOT NULL UNIQUE,
DT_NASCIMENTO DATE,
DT_CADASTRO DATE,
EMAIL VARCHAR(60),
TELEFONE VARCHAR(14),
CELULAR VARCHAR(14) NOT NULL,
DT_VENCIMENTO NUMERIC(2) NOT NULL,
RUA VARCHAR(60) NOT NULL,
NUMERO VARCHAR(10) NOT NULL,
BAIRRO VARCHAR(50) NOT NULL,
CIDADE VARCHAR(50) NOT NULL,
UF VARCHAR(50) NOT NULL,
CEP VARCHAR(9) NOT NULL,
LOGIN VARCHAR(15) NOT NULL UNIQUE,
SENHA VARCHAR(30) NOT NULL,
TIPOPLANO VARCHAR(20) NOT NULL,
OPERADORA VARCHAR(10) NOT NULL,
CONSTRAINT PK_ID_CLIENTE PRIMARY KEY(ID_CLIENTE)
);

CREATE TABLE FORNECEDOR(
ID_FORNECEDOR INTEGER AUTO_INCREMENT,
NOMEFANTASIA VARCHAR(60) NOT NULL,
RAZAOSOCIAL VARCHAR(60) NOT NULL,
CNPJ VARCHAR(18) NOT NULL UNIQUE,
IE VARCHAR(15),
RUA VARCHAR(60) NOT NULL,
NUMERO VARCHAR(10) NOT NULL,
BAIRRO VARCHAR(50) NOT NULL,
CIDADE VARCHAR(50) NOT NULL,
UF VARCHAR(50) NOT NULL,
CEP VARCHAR(9) NOT NULL,
EMAIL VARCHAR(60),
TELEFONE VARCHAR(14),
CELULAR VARCHAR(14) NOT NULL,
OPERADORA VARCHAR(10) NOT NULL,
CONSTRAINT PK_ID_FORNECEDOR PRIMARY KEY(ID_FORNECEDOR)
);

CREATE TABLE CHAMADO(
ID_CHAMADO INTEGER AUTO_INCREMENT, 
CPF_CLIENTE VARCHAR(14) NOT NULL,
TIPOCHAMADO VARCHAR(30),
DESCPROBLEMA VARCHAR(150) NOT NULL,
DESCPROBLEMA2 VARCHAR(150) NOT NULL,
STATUS VARCHAR(16),
DT_ABERTURA DATE,
DT_FECHAMENTO DATE,
CONSTRAINT PK_ID_CHAMADO PRIMARY KEY(ID_CHAMADO),
CONSTRAINT FK_CHAMADO_CPF_CLIENTE FOREIGN KEY (CPF_CLIENTE) REFERENCES CLIENTE (CPF)
);

CREATE TABLE CONTA(
ID_CONTA INTEGER AUTO_INCREMENT,
TIPOCONTA VARCHAR(16),
STATUSCONTA VARCHAR(16),
CPF_CLIENTE VARCHAR(14) NOT NULL,
VALOR DOUBLE PRECISION,
DESCONTO DOUBLE PRECISION,
TOTAL DOUBLE PRECISION,
DT_ABERTURA DATE,
DT_VENCIMENTO DATE,
DT_PAGO DATE,
QTD_PARCELAS VARCHAR(5),
CONSTRAINT PK_ID_CONTA PRIMARY KEY(ID_CONTA),
CONSTRAINT FK_CONTA_CPF_CLIENTE FOREIGN KEY(CPF_CLIENTE) REFERENCES CLIENTE (CPF)
);

USE `projetointerdisciplinar_sgp`;
DROP procedure IF EXISTS `conta_insert`;

DELIMITER $$
USE `projetointerdisciplinar_sgp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `conta_insert`( 
in P_TIPOCONTA VARCHAR(16),
in P_STATUSCONTA VARCHAR(16),
in P_CPF_CLIENTE VARCHAR(14),
in P_VALOR DOUBLE PRECISION,
in P_DESCONTO DOUBLE PRECISION,
in P_TOTAL DOUBLE PRECISION,
in P_DT_ABERTURA DATE,
in P_DT_VENCIMENTO DATE,
in P_QTD_PARCELAS integer)
BEGIN
declare qtdParcela int default 0;
DECLARE contador INT DEFAULT 0;
DECLARE contMes INT DEFAULT 0;
DECLARE DTVENC date;
set qtdParcela = P_QTD_PARCELAS;
SET DTVENC = P_DT_VENCIMENTO;
loop_insert: LOOP
	SET contador = contador + 1;
    
	INSERT INTO conta (TIPOCONTA, STATUSCONTA, CPF_CLIENTE, VALOR, DESCONTO, TOTAL, DT_ABERTURA, DT_VENCIMENTO, QTD_PARCELAS)
	VALUES (P_TIPOCONTA, P_STATUSCONTA, P_CPF_CLIENTE, P_VALOR, P_DESCONTO, P_TOTAL, P_DT_ABERTURA, DTVENC, concat(contador, '/', P_QTD_PARCELAS));
	
    SET DTVENC = ADDDATE( DTVENC, INTERVAL 1 month);
    
	IF contador >= qtdParcela THEN
        LEAVE loop_insert;
    END IF;

END LOOP loop_insert;    
END$$

DELIMITER ;