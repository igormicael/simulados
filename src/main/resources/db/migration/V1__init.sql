create sequence alternativa_seq start 1 increment 1;
create sequence disciplina_seq start 1 increment 1;
create sequence gabarito_seq start 1 increment 1;
create sequence prova_seq start 1 increment 1;
create sequence questao_seq start 1 increment 1;
create sequence resposta_seq start 1 increment 1;
create sequence simulado_seq start 1 increment 1;

create table alternativa (id int8 not null, descricao varchar(255), questao_id int8, primary key (id) );
create table disciplina (id int8 not null, nome varchar(255), nome_professor varchar(255), primary key (id));
create table gabarito (id int8 not null, prova_id int8,  primary key (id));
create table prova (id int8 not null, disciplina_id int8, gabarito_id int8, simulado_id int8,  primary key (id));
create table questao (id int8 not null, enunciado varchar(255), dificuldade_questao varchar(255), tipo_questao varchar(255), prova_id int8, primary key (id));
create table resposta (id int8 not null, questao_id int8, alternativa_id int8, gabarito_id int8, primary key (id));
create table simulado (id int8 not null, data date, tipo varchar(255), primary key (id));