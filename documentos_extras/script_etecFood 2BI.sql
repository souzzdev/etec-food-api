CREATE DATABASE etec_food;
Use etec_food;


--Grupo 1: Usuário

CREATE TABLE TBL_USUARIO (
	ID_USUARIO BIGINT NOT NULL PRIMARY KEY IDENTITY,
	TX_NOME VARCHAR(60) NOT NULL,
	TX_SENHA VARCHAR(25) NOT NULL,
	NR_TENTATIVAS_ACESSO INT NOT NULL,
	DT_DATA_BLOQUEIO DATETIME NOT NULL,
	/* DT_DATA_INATIVACAO DATETIME NOT NULL, */
	TX_STATUS VARCHAR(20) NOT NULL,
	CONSTRAINT CK_Usuario_Status CHECK (status IN ('ATIVO','INATIVO','BLOQUEADO'))   
);

create table TBL_PERMISSAO(
	ID_PERMISSAO BIGINT PRIMARY KEY,
	TX_AUTHORITY VARCHAR(35) NOT NULL
);

-- Tabela de relacionamento Usuario x Permissao (N:N)
CREATE TABLE TBL_USUARIO_PERMISSAO (
    ID_USUARIO BIGINT NOT NULL,
    ID_PERMISSAO BIGINT NOT NULL,
    PRIMARY KEY (ID_USUARIO, ID_PERMISSAO),
    FOREIGN KEY (ID_USUARIO) REFERENCES TBL_USUARIO(ID_USUARIO),
    FOREIGN KEY (ID_PERMISSAO) REFERENCES TBL_PERMISSAO(ID_PERMISSAO)
);

-- Grupo 2: Gerenciamento de Restaurante
-- Restaurante, HorarioFuncionamento, TipoCozinhaEnum, RestauranteFormaPagamento, RestauranteFormaPagamentoId
CREATE TABLE Tbl_Restaurante (
    	id_restaurante BigInt primary key,
	tx_cnpj varchar (14) not null,
	tx_nome varchar(250) not null,
	tx_descrição varchar (250) not null,
	tx_cep varchar(9) not null,
	tx_endereco varchar (100) not null, 
	nr_taxaDeEntrega float not null,
	nr_tempoDeEntregaMinimo int not null,
	nr_tempoDeEntregaMaximo int not null,
	bool_aprovado bit not null,
	tx_TipoCozinhaEnum varchar(20) not null,
    ID_USUARIO BIGINT NOT NULL,
    FOREIGN KEY (ID_USUARIO) REFERENCES TBL_USUARIO(ID_USUARIO),
    CONSTRAINT CK_Restaurante_TipoCozinha CHECK (
        tipoDeCozinha IN ('CHINESA','JAPONESA','MEXICANA','MINEIRA','BAIANA',
                          'LANCHES','HAMBURGER','ARABE','ITALIANA','VARIADA')
    )
);

CREATE TABLE Tbl_Horario_Funcionamento (
   id_horarioFuncionamento BigInt primary key,
	dt_diaSemana varchar(15),
	dt_horarioAbertura Time,
	dt_horarioFechamento Time,
	id_restaurante Bigint references Tbl_Restaurante
);


CREATE TABLE Tbl_Restaurante_Forma_Pagamento (
    id_restaurante BIGINT NOT NULL,
    formaPagamento_id BIGINT NOT NULL,
    PRIMARY KEY (restaurante_id, formaPagamento_id),
    FOREIGN KEY (restaurante_id) REFERENCES Restaurante(id),
    FOREIGN KEY (formaPagamento_id) REFERENCES FormaPagamento(id)
);

--Grupo 3: FormaPagamento, Pagamento, TipoFormaPagamentoEnum, StatusPagamentoEnum, 
CREATE TABLE FormaPagamento (
    id BIGINT PRIMARY KEY IDENTITY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    CONSTRAINT CK_FormaPagamento_Tipo CHECK (tipo IN ('CARTAO_CREDITO','CARTAO_DEBITO','VALE_REFEICAO'))
);

CREATE TABLE Pagamento (
    id BIGINT PRIMARY KEY IDENTITY,
    valor DECIMAL(10,2) NOT NULL,
    nome VARCHAR(100),
    numero VARCHAR(30),
    expiracao VARCHAR(10),
    codigo VARCHAR(10),
    status VARCHAR(20) NOT NULL,
    formaPagamento_id BIGINT NOT NULL,
 --   FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (formaPagamento_id) REFERENCES FormaPagamento(id),
    CONSTRAINT CK_Pagamento_Status CHECK (status IN ('CRIADO','CONFIRMADO','CANCELADO'))
);

-- Alteração da tabela inserindo a FK pedido - Corrigido por Marion
ALTER TABLE Pagamento add pedido_id BIGINT NOT NULL REFERENCES Pedido(id)

--GRUPO 4 - Cardápio
--INTEGRANTES: Isadora Neves, LIkas Santos, Isaac Barbosa, Natanael Roberto, Fernanda Souza e Luiza Brito


CREATE TABLE Cardapio (
     id_cardapio BIGINT PRIMARY KEY IDENTITY,
--    id_restaurante BIGINT NOT NULL,
--    FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id)
);


alter table cardapio add id_restaurante BIGINT not null

alter table Cardapio add constraint id_Restaurante_fk foreign key(id_restaurante) references Restaurante(id_restaurante)

CREATE TABLE ItemCardapio (
    id_item_cardapio BIGINT PRIMARY KEY IDENTITY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    tipo VARCHAR(20) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    precoPromocional DECIMAL(10,2),
    id_cardapio BIGINT NOT NULL,
    FOREIGN KEY (id_cardapio) REFERENCES Cardapio(id),
    CONSTRAINT CK_ItemCardapio_Tipo CHECK (tipo IN ('ENTRADA','PRATO_PRINCIPAL','BEBIDA'))
);

-- Grupo 5: Cliente e Entrega
-- Integrantes: Guilherme Souza, Gustavo Salgado, Iago Luiz, Sergio Luiz, Ricky Abreu

CREATE TABLE TBL_CLIENTE (
    ID_CLIENTE BIGINT PRIMARY KEY IDENTITY,
    TX_NOME VARCHAR(150) NOT NULL,
    TX_CPF VARCHAR(14) UNIQUE NOT NULL,
    TX_EMAIL VARCHAR(100) UNIQUE NOT NULL,
    TX_TELEFONE VARCHAR(11),
    BO_VALIDADO BIT DEFAULT 0
);

--Anderson Filipim, Cauã Santos, Gabriel de Albuquerque,
--Jonatas Calebe, Miguel Angel, Victor de Melo

CREATE TABLE Pedido (
    ID_PEDIDO BIGINT PRIMARY KEY IDENTITY,
    DATA DATETIME NOT NULL,
    STATUS VARCHAR(20) NOT NULL,
    id_restaurante BIGINT NOT NULL,
    FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id),
    CONSTRAINT CK_Pedido_Status CHECK (
        status IN ('REALIZADO','PAGO','CONFIRMADO','PRONTO','SAIU_PARA_ENTREGA','ENTREGUE')
    )
);


CREATE TABLE ITEM_PEDIDO (
    ID_ITEM_PEDIDO BIGINT PRIMARY KEY IDENTITY,
    quantidade INT NOT NULL,
    observacao VARCHAR(255),
    pedido_id BIGINT NOT NULL,
    itemCardapio_id BIGINT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(ID_PEDIDO),
    FOREIGN KEY (itemCardapio_id) REFERENCES ItemCardapio(id)
);

CREATE TABLE Avaliacao (
    ID_AVALIACAO BIGINT PRIMARY KEY IDENTITY,
    NOTA INT NOT NULL,
    COMENTARIO VARCHAR(255),
    PEDIDO_ID BIGINT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(ID_PEDIDO)
);

--Grupo 7: Logistica
--Guilherme Rosseto Valentim, João Pedro Vieira, Lucas de Andrade Moraes,
--Raphael Luis, Vinicius Kobayashi

CREATE TABLE Entregador (
    ID_ENT BIGINT PRIMARY KEY IDENTITY,
    TX_NOME_ENT VARCHAR(150) NOT NULL,
    TX_TELEFONE_ENT VARCHAR(20),
    ATIVO BIT DEFAULT 1
);

CREATE TABLE Veiculo (
    ID_VEIC BIGINT PRIMARY KEY IDENTITY,
    TX_PLACA_VEIC VARCHAR(10) UNIQUE NOT NULL,
    TIPO_VEIC VARCHAR(20) NOT NULL,
    ID_ENT BIGINT NOT NULL,
    FOREIGN KEY (ID_ENT) REFERENCES Entregador(ID_ENT),
    CONSTRAINT CK_Veiculo_Tipo CHECK (tipo IN ('MOTO','CARRO','BICICLETA','OUTRO'))
);

