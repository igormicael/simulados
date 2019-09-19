insert into gabarito(id, prova_id)
values (nextval ('gabarito_seq'), 1);

update alternativa set gabarito_id = 1 where id in 
(2,8,11,16,25,29,31,36,41,46);

insert into gabarito(id, prova_id)
values (nextval ('gabarito_seq'), 2);

update alternativa set gabarito_id = 2 where id in 
(51,58,63,70,71,78,84,85,95,98);