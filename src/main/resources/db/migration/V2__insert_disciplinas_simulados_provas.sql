insert into disciplina(id, nome , nome_professor)
values (nextval ('disciplina_seq'), 'atualidades', 'aline'); -- 1
insert into disciplina(id, nome , nome_professor)
values (nextval ('disciplina_seq'), 'historia', 'cléo'); -- 2
insert into disciplina(id, nome , nome_professor)
values (nextval ('disciplina_seq'), 'geografia', 'fabio'); -- 3

insert into simulado(id, data, tipo)
values (nextval ('simulado_seq'), now(), 'HUMANAS'); -- 1

insert into prova(id, disciplina_id, simulado_id)
values (nextval ('prova_seq'), 1 ,1 ); -- atualidades -- 1

insert into prova(id, disciplina_id, simulado_id)
values (nextval ('prova_seq'), 2 ,1 ); -- atualidades -- 4