CREATE TABLE public.alternativa (
    id bigint NOT NULL,
    descricao character varying(255),
    gabarito_id bigint NOT NULL,
    questao_id bigint NOT NULL
);

CREATE TABLE public.alternativa_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    descricao character varying(255),
    gabarito_id bigint,
    questao_id bigint
);


ALTER TABLE public.alternativa_aud OWNER TO postgres;


CREATE SEQUENCE public.alternativa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alternativa_seq OWNER TO postgres;

CREATE TABLE public.aluno (
    id bigint NOT NULL,
    cpf character varying(255)
);


ALTER TABLE public.aluno OWNER TO postgres;


CREATE TABLE public.aluno_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    cpf character varying(255)
);


ALTER TABLE public.aluno_aud OWNER TO postgres;

CREATE TABLE public.aluno_resposta (
    id bigint NOT NULL,
    aluno_id bigint NOT NULL,
    prova_id bigint NOT NULL,
    questao_id bigint NOT NULL,
    alternativa_id bigint NOT NULL,
    simulado_id bigint NOT NULL
);


ALTER TABLE public.aluno_resposta OWNER TO postgres;


CREATE TABLE public.aluno_resposta_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    aluno_id bigint,
    prova_id bigint,
    questao_id bigint,
    alternativa_id bigint,
    simulado_id bigint
);


ALTER TABLE public.aluno_resposta_aud OWNER TO postgres;


CREATE SEQUENCE public.aluno_resposta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.aluno_resposta_seq OWNER TO postgres;


CREATE SEQUENCE public.aluno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.aluno_seq OWNER TO postgres;


CREATE TABLE public.disciplina (
    id bigint NOT NULL,
    nome character varying(255),
    nome_professor character varying(255)
);


ALTER TABLE public.disciplina OWNER TO postgres;


CREATE TABLE public.disciplina_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    nome character varying(255),
    nome_professor character varying(255)
);


ALTER TABLE public.disciplina_aud OWNER TO postgres;


CREATE SEQUENCE public.disciplina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.disciplina_seq OWNER TO postgres;


CREATE TABLE public.gabarito (
    id bigint NOT NULL,
    desativacao timestamp without time zone,
    prova_id bigint NOT NULL
);


ALTER TABLE public.gabarito OWNER TO postgres;

CREATE TABLE public.gabarito_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    desativacao timestamp without time zone,
    prova_id bigint
);


ALTER TABLE public.gabarito_aud OWNER TO postgres;

CREATE SEQUENCE public.gabarito_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gabarito_seq OWNER TO postgres;

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.hibernate_sequence OWNER TO postgres;

CREATE TABLE public.prova (
    id bigint NOT NULL,
    dificuldade_questao character varying(255),
    enunciado character varying(255),
    prova_id bigint NOT NULL,
    disciplina_id bigint NOT NULL,
    gabarito_id bigint NOT NULL,
    simulado_id bigint NOT NULL
);


ALTER TABLE public.prova OWNER TO postgres;

CREATE TABLE public.prova_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    disciplina_id bigint,
    gabarito_id bigint,
    simulado_id bigint,
    dificuldade_questao character varying(255),
    enunciado character varying(255),
    prova_id bigint
);


ALTER TABLE public.prova_aud OWNER TO postgres;

CREATE SEQUENCE public.prova_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prova_seq OWNER TO postgres;

CREATE TABLE public.questao (
    id bigint NOT NULL,
    enunciado character varying(255),
    dificuldade_questao character varying(255),
    prova_id bigint
);


ALTER TABLE public.questao OWNER TO postgres;

CREATE SEQUENCE public.questao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.questao_seq OWNER TO postgres;

CREATE TABLE public.resposta (
    id bigint NOT NULL,
    questao_id bigint,
    alternativa_id bigint,
    gabarito_id bigint
);


ALTER TABLE public.resposta OWNER TO postgres;

CREATE SEQUENCE public.resposta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resposta_seq OWNER TO postgres;

CREATE TABLE public.revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


ALTER TABLE public.revinfo OWNER TO postgres;

CREATE TABLE public.simulado (
    id bigint NOT NULL,
    data timestamp without time zone,
    tipo character varying(255)
);


ALTER TABLE public.simulado OWNER TO postgres;

CREATE TABLE public.simulado_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data timestamp without time zone,
    tipo character varying(255)
);


ALTER TABLE public.simulado_aud OWNER TO postgres;

CREATE SEQUENCE public.simulado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.simulado_seq OWNER TO postgres;

ALTER TABLE ONLY public.alternativa_aud
    ADD CONSTRAINT alternativa_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.alternativa
    ADD CONSTRAINT alternativa_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.aluno_aud
    ADD CONSTRAINT aluno_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.aluno_resposta_aud
    ADD CONSTRAINT aluno_resposta_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT aluno_resposta_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.disciplina_aud
    ADD CONSTRAINT disciplina_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.gabarito_aud
    ADD CONSTRAINT gabarito_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.gabarito
    ADD CONSTRAINT gabarito_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.prova_aud
    ADD CONSTRAINT prova_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.questao
    ADD CONSTRAINT questao_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.resposta
    ADD CONSTRAINT resposta_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);

ALTER TABLE ONLY public.simulado_aud
    ADD CONSTRAINT simulado_aud_pkey PRIMARY KEY (id, rev);

ALTER TABLE ONLY public.simulado
    ADD CONSTRAINT simulado_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.alternativa
    ADD CONSTRAINT alternativa_gabrito_id FOREIGN KEY (gabarito_id) REFERENCES public.gabarito(id);

ALTER TABLE ONLY public.alternativa
    ADD CONSTRAINT alternativa_questao_id FOREIGN KEY (questao_id) REFERENCES public.prova(id);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT ar_alternativa_id FOREIGN KEY (alternativa_id) REFERENCES public.alternativa(id);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT ar_aluno_id FOREIGN KEY (aluno_id) REFERENCES public.aluno(id);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT ar_prova_id FOREIGN KEY (prova_id) REFERENCES public.prova(id);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT ar_questao_id FOREIGN KEY (questao_id) REFERENCES public.prova(id);

ALTER TABLE ONLY public.aluno_resposta
    ADD CONSTRAINT ar_simulado_id FOREIGN KEY (simulado_id) REFERENCES public.simulado(id);

ALTER TABLE ONLY public.aluno_resposta_aud
    ADD CONSTRAINT fk3idp4gtysopb7surshwj6ofi3 FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.simulado_aud
    ADD CONSTRAINT fk75ey7qjvo28pi04nk1bfoubji FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.prova_aud
    ADD CONSTRAINT fkbdfnjicr7xc696knymcn9awtt FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.disciplina_aud
    ADD CONSTRAINT fkdnfao9mcf2cvco906s702oew4 FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.alternativa_aud
    ADD CONSTRAINT fkp6kkgxi5yryijpbktn4jvvnlp FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.gabarito_aud
    ADD CONSTRAINT fkpham86fdciush1rd6l2dqon5c FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.aluno_aud
    ADD CONSTRAINT fktaslm8utk5h6auby7uu9hti7g FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

ALTER TABLE ONLY public.gabarito
    ADD CONSTRAINT gabrito_prova_id FOREIGN KEY (prova_id) REFERENCES public.prova(id);

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_disciplina_id FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(id);

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_gabarito_id FOREIGN KEY (gabarito_id) REFERENCES public.gabarito(id);

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_simulado_id FOREIGN KEY (simulado_id) REFERENCES public.simulado(id);

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT resposta_gabarito_id FOREIGN KEY (prova_id) REFERENCES public.prova(id);