-- MySQL
CREATE TABLE IF NOT EXISTS Empresa(
    id_empresa int primary key auto_increment,
    nome_empresa varchar(50),
    CNPJ char(14),
    telefone varchar(20)
);

CREATE TABLE IF NOT EXISTS Usuario(
    id_usuario int primary key auto_increment,
    fk_empresa int,
    foreign key (fk_empresa) references Empresa(id_empresa),
    tipo_usuario varchar(50),
    constraint "chk_tipoUsuario" check(tipo_usuario in("admin", "gerente", "suporte")),
    nome_usuario varchar(50),
    email varchar(50),
    senha varchar(50),
    primero_acesso tinyint
);

CREATE TABLE IF NOT EXISTS Servidor(
    id_servidor int primary key auto_increment,
    fk_empresa int,
    foreign key(fk_empresa) references Empresa(id_empresa),
    qtd_armazenamento double,
    max_utilizacao_disco double,
    qtd_nucleos int,
    clock double,
    max_utilizacao_processador double,
    qtd_ram double,
    max_utilizacao_ram double
);

CREATE TABLE IF NOT EXISTS RegistroServer(
    id_dado int primary key auto_increment,
    fk_servidor int,
    foreign key(fk_servidor) references Servidor(fk_servidor),
    ram_em_uso double,
    disco_em_uso double,
    processador_em_uso double,
    data_registro datetime
);