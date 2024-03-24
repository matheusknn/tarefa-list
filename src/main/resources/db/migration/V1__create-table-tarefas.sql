create table tarefas(

    id bigint not null auto_increment,
    titulo varchar(200) not null,
    criacao datetime not null,
    limite datetime not null,
    finalizacao date,

    primary key(id).
);