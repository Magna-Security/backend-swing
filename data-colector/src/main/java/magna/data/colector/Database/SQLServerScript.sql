CREATE TABLE Empresa(
    id_empresa int primary key identity,
    nome_empresa varchar(50),
    CNPJ char(14),
    telefone varchar(20)
);

CREATE TABLE Usuario(
    id_usuario int primary key identity,
    fk_empresa int,
    foreign key (fk_empresa) references Empresa(id_empresa),
    tipo_usuario varchar(50),
    CONSTRAINT "chk_tipoUsuario" CHECK (tipo_usuario in('admin', 'gerente', 'suporte')),
    nome_usuario varchar(50),
    email varchar(50),
    senha varchar(50),
    primero_acesso tinyint,
    acesso_ao_swing tinyint
);

CREATE TABLE Servidor(
    id_servidor int primary key identity,
    fk_empresa int,
    foreign key(fk_empresa) references Empresa(id_empresa),
    qtd_nucleos_fisicos int,
    qtd_nucleos_logicos int,
	max_utilizacao_cpu decimal(10,2),
	qtd_memoria_ram bigint,
	max_utilizacao_ram decimal(10,2),
	total_armazenamento_disco_1 bigint,
	total_armazenamento_disco_2 bigint,
	total_armazenamento_disco_3 bigint,
	total_armazenamento_disco_4 bigint
);

CREATE TABLE RegistroServer(
    id_dado int primary key identity,
    fk_servidor int,
    foreign key(fk_servidor) references Servidor(id_servidor),
    qtd_processos int,
	qtd_threads int,
	cpu_em_uso decimal(10,2),
	ram_em_uso bigint,
	disco_em_uso_1 bigint,
	disco_em_uso_2 bigint,
	disco_em_uso_3 bigint,
	disco_em_uso_4 bigint,
    dt_registro datetime
);

