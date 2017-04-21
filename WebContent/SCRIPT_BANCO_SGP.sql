CREATE TABLE USERADMIN(
ID_ADM INTEGER AUTO_INCREMENT,
NOME VARCHAR(60) NOT NULL,
LOGIN VARCHAR(15) NOT NULL UNIQUE,
SENHA VARCHAR(8) NOT NULL,
CONSTRAINT PK_ID_ADM PRIMARY KEY(ID_ADM)
);

CREATE TABLE PLANO(
IDPLANO INTEGER AUTO_INCREMENT,
NOME VARCHAR(20) NOT NULL UNIQUE,
UPLOAD INTEGER NOT NULL,
DOWNLOAD INTEGER NOT NULL,
VALOR DOUBLE PRECISION,
CONSTRAINT PK_IDPLANO PRIMARY KEY(IDPLANO)
);

CREATE TABLE CLIENTE(
ID_CLIENTE INTEGER AUTO_INCREMENT,
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
SENHA VARCHAR(8) NOT NULL,
TIPOPLANO VARCHAR(20) NOT NULL,
OPERADORA VARCHAR(10) NOT NULL,
CONSTRAINT PK_ID_CLIENTE PRIMARY KEY(ID_CLIENTE)
);

CREATE TABLE FORNECEDOR(
ID_FORNECEDOR INTEGER AUTO_INCREMENT,
NOMEFANTASIA VARCHAR(60) NOT NULL,
RAZAOSOCIAL VARCHAR(60) NOT NULL,
CNPJ VARCHAR(18) NOT NULL UNIQUE,
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
ID_CLIENTE INTEGER,
TIPOCHAMADO VARCHAR(30),
DESCPROBLEMA VARCHAR(150) NOT NULL,
STATUS VARCHAR(16),
DT_ABERTURA DATE,
DT_FECHAMENTO DATE,
CONSTRAINT PK_ID_CHAMADO PRIMARY KEY(ID_CHAMADO),
CONSTRAINT FK_CHAMADO_ID_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE)
);

CREATE TABLE CONTA(
ID_CONTA INTEGER AUTO_INCREMENT,
TIPOCONTA VARCHAR(16),
STATUSCONTA VARCHAR(16),
ID_CLIENTE INTEGER,
VALOR DOUBLE PRECISION,
DESCONTO DOUBLE PRECISION,
ACRESCIMO DOUBLE PRECISION,
VALORTOTAL DOUBLE PRECISION,
CONSTRAINT PK_ID_CONTA PRIMARY KEY(ID_CONTA),
CONSTRAINT FK_CONTA_ID_CLIENTE FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE)
);