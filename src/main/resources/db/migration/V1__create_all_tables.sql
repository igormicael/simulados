CREATE TABLE alternativa (
    id bigint NOT NULL,
    descricao character varying(255),
    gabarito_id bigint,
    questao_id bigint NOT NULL
);


--
-- TOC entry 193 (class 1259 OID 45888)
-- Name: alternativa_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE alternativa_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    descricao character varying(255),
    gabarito_id bigint,
    questao_id bigint
);


--
-- TOC entry 185 (class 1259 OID 45869)
-- Name: alternativa_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE alternativa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 194 (class 1259 OID 45893)
-- Name: aluno; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE aluno (
    id bigint NOT NULL,
    nome character varying(255), 
    cpf character varying(255)
);

CREATE TABLE aluno_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    nome character varying(255), 
    cpf character varying(255)
);


--
-- TOC entry 196 (class 1259 OID 45903)
-- Name: aluno_resposta; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE aluno_resposta (
    id bigint NOT NULL,
    aluno_id bigint NOT NULL,
    prova_id bigint NOT NULL,
    questao_id bigint NOT NULL,
    alternativa_id bigint NOT NULL,
    simulado_id bigint NOT NULL
);


--
-- TOC entry 197 (class 1259 OID 45908)
-- Name: aluno_resposta_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE aluno_resposta_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    aluno_id bigint,
    prova_id bigint,
    questao_id bigint,
    alternativa_id bigint,
    simulado_id bigint
);


--
-- TOC entry 186 (class 1259 OID 45871)
-- Name: aluno_resposta_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE aluno_resposta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 187 (class 1259 OID 45873)
-- Name: aluno_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE aluno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 198 (class 1259 OID 45913)
-- Name: disciplina; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE disciplina (
    id bigint NOT NULL,
    nome character varying(255),
    nome_professor character varying(255)
);


--
-- TOC entry 199 (class 1259 OID 45921)
-- Name: disciplina_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE disciplina_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    nome character varying(255),
    nome_professor character varying(255)
);


--
-- TOC entry 188 (class 1259 OID 45875)
-- Name: disciplina_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE disciplina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 200 (class 1259 OID 45929)
-- Name: gabarito; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE gabarito (
    id bigint NOT NULL,
    desativacao timestamp without time zone,
    prova_id bigint NOT NULL
);


--
-- TOC entry 201 (class 1259 OID 45934)
-- Name: gabarito_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE gabarito_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    desativacao timestamp without time zone,
    prova_id bigint
);

CREATE SEQUENCE gabarito_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 189 (class 1259 OID 45877)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 202 (class 1259 OID 45939)
-- Name: prova; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE prova (
    id bigint NOT NULL,
    disciplina_id bigint NOT NULL,
    gabarito_id bigint,
    simulado_id bigint NOT NULL
);


--
-- TOC entry 203 (class 1259 OID 45944)
-- Name: prova_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE prova_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    disciplina_id bigint,
    gabarito_id bigint,
    simulado_id bigint
);

--
-- TOC entry 188 (class 1259 OID 45875)
-- Name: prova_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE prova_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 204 (class 1259 OID 45949)
-- Name: questao; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE questao (
    id bigint NOT NULL,
    dificuldade_questao character varying(255),
    enunciado character varying(255),
    prova_id bigint NOT NULL
);


--
-- TOC entry 205 (class 1259 OID 45957)
-- Name: questao_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE questao_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    dificuldade_questao character varying(255),
    enunciado character varying(255),
    prova_id bigint
);


--
-- TOC entry 190 (class 1259 OID 45879)
-- Name: questao_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE questao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 206 (class 1259 OID 45965)
-- Name: revinfo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


--
-- TOC entry 207 (class 1259 OID 45970)
-- Name: simulado; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE simulado (
    id bigint NOT NULL,
    data timestamp without time zone,
    tipo character varying(255)
);


--
-- TOC entry 208 (class 1259 OID 45975)
-- Name: simulado_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE simulado_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data timestamp without time zone,
    tipo character varying(255)
);


--
-- TOC entry 191 (class 1259 OID 45881)
-- Name: simulado_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE simulado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2126 (class 2606 OID 45892)
-- Name: alternativa_aud alternativa_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY alternativa_aud
    ADD CONSTRAINT alternativa_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2124 (class 2606 OID 45887)
-- Name: alternativa alternativa_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY alternativa
    ADD CONSTRAINT alternativa_pkey PRIMARY KEY (id);


--
-- TOC entry 2130 (class 2606 OID 45902)
-- Name: aluno_aud aluno_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_aud
    ADD CONSTRAINT aluno_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2128 (class 2606 OID 45897)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);


--
-- TOC entry 2134 (class 2606 OID 45912)
-- Name: aluno_resposta_aud aluno_resposta_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta_aud
    ADD CONSTRAINT aluno_resposta_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2132 (class 2606 OID 45907)
-- Name: aluno_resposta aluno_resposta_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT aluno_resposta_pkey PRIMARY KEY (id);


--
-- TOC entry 2138 (class 2606 OID 45928)
-- Name: disciplina_aud disciplina_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY disciplina_aud
    ADD CONSTRAINT disciplina_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2136 (class 2606 OID 45920)
-- Name: disciplina disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id);


--
-- TOC entry 2142 (class 2606 OID 45938)
-- Name: gabarito_aud gabarito_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gabarito_aud
    ADD CONSTRAINT gabarito_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2140 (class 2606 OID 45933)
-- Name: gabarito gabarito_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gabarito
    ADD CONSTRAINT gabarito_pkey PRIMARY KEY (id);


--
-- TOC entry 2146 (class 2606 OID 45948)
-- Name: prova_aud prova_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova_aud
    ADD CONSTRAINT prova_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2144 (class 2606 OID 45943)
-- Name: prova prova_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova
    ADD CONSTRAINT prova_pkey PRIMARY KEY (id);


--
-- TOC entry 2150 (class 2606 OID 45964)
-- Name: questao_aud questao_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY questao_aud
    ADD CONSTRAINT questao_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2148 (class 2606 OID 45956)
-- Name: questao questao_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY questao
    ADD CONSTRAINT questao_pkey PRIMARY KEY (id);


--
-- TOC entry 2152 (class 2606 OID 45969)
-- Name: revinfo revinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- TOC entry 2156 (class 2606 OID 45979)
-- Name: simulado_aud simulado_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY simulado_aud
    ADD CONSTRAINT simulado_aud_pkey PRIMARY KEY (id, rev);


--
-- TOC entry 2154 (class 2606 OID 45974)
-- Name: simulado simulado_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY simulado
    ADD CONSTRAINT simulado_pkey PRIMARY KEY (id);


--
-- TOC entry 2157 (class 2606 OID 45980)
-- Name: alternativa alternativa_gabrito_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY alternativa
    ADD CONSTRAINT alternativa_gabrito_id FOREIGN KEY (gabarito_id) REFERENCES gabarito(id);


--
-- TOC entry 2158 (class 2606 OID 45985)
-- Name: alternativa alternativa_questao_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY alternativa
    ADD CONSTRAINT alternativa_questao_id FOREIGN KEY (questao_id) REFERENCES questao(id);


--
-- TOC entry 2164 (class 2606 OID 46015)
-- Name: aluno_resposta ar_alternativa_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT ar_alternativa_id FOREIGN KEY (alternativa_id) REFERENCES alternativa(id);


--
-- TOC entry 2161 (class 2606 OID 46000)
-- Name: aluno_resposta ar_aluno_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT ar_aluno_id FOREIGN KEY (aluno_id) REFERENCES aluno(id);


--
-- TOC entry 2162 (class 2606 OID 46005)
-- Name: aluno_resposta ar_prova_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT ar_prova_id FOREIGN KEY (prova_id) REFERENCES prova(id);


--
-- TOC entry 2163 (class 2606 OID 46010)
-- Name: aluno_resposta ar_questao_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT ar_questao_id FOREIGN KEY (questao_id) REFERENCES questao(id);


--
-- TOC entry 2165 (class 2606 OID 46020)
-- Name: aluno_resposta ar_simulado_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta
    ADD CONSTRAINT ar_simulado_id FOREIGN KEY (simulado_id) REFERENCES simulado(id);


--
-- TOC entry 2175 (class 2606 OID 46070)
-- Name: questao_aud fk1ndqobi7y7ksypid2vbmd07mw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY questao_aud
    ADD CONSTRAINT fk1ndqobi7y7ksypid2vbmd07mw FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2166 (class 2606 OID 46025)
-- Name: aluno_resposta_aud fk3idp4gtysopb7surshwj6ofi3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_resposta_aud
    ADD CONSTRAINT fk3idp4gtysopb7surshwj6ofi3 FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2176 (class 2606 OID 46075)
-- Name: simulado_aud fk75ey7qjvo28pi04nk1bfoubji; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY simulado_aud
    ADD CONSTRAINT fk75ey7qjvo28pi04nk1bfoubji FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2173 (class 2606 OID 46060)
-- Name: prova_aud fkbdfnjicr7xc696knymcn9awtt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova_aud
    ADD CONSTRAINT fkbdfnjicr7xc696knymcn9awtt FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2167 (class 2606 OID 46030)
-- Name: disciplina_aud fkdnfao9mcf2cvco906s702oew4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY disciplina_aud
    ADD CONSTRAINT fkdnfao9mcf2cvco906s702oew4 FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2159 (class 2606 OID 45990)
-- Name: alternativa_aud fkp6kkgxi5yryijpbktn4jvvnlp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY alternativa_aud
    ADD CONSTRAINT fkp6kkgxi5yryijpbktn4jvvnlp FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2169 (class 2606 OID 46040)
-- Name: gabarito_aud fkpham86fdciush1rd6l2dqon5c; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gabarito_aud
    ADD CONSTRAINT fkpham86fdciush1rd6l2dqon5c FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2160 (class 2606 OID 45995)
-- Name: aluno_aud fktaslm8utk5h6auby7uu9hti7g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aluno_aud
    ADD CONSTRAINT fktaslm8utk5h6auby7uu9hti7g FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- TOC entry 2168 (class 2606 OID 46035)
-- Name: gabarito gabrito_prova_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gabarito
    ADD CONSTRAINT gabrito_prova_id FOREIGN KEY (prova_id) REFERENCES prova(id);


--
-- TOC entry 2170 (class 2606 OID 46045)
-- Name: prova prova_disciplina_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova
    ADD CONSTRAINT prova_disciplina_id FOREIGN KEY (disciplina_id) REFERENCES disciplina(id);


--
-- TOC entry 2171 (class 2606 OID 46050)
-- Name: prova prova_gabarito_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova
    ADD CONSTRAINT prova_gabarito_id FOREIGN KEY (gabarito_id) REFERENCES gabarito(id);


--
-- TOC entry 2172 (class 2606 OID 46055)
-- Name: prova prova_simulado_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY prova
    ADD CONSTRAINT prova_simulado_id FOREIGN KEY (simulado_id) REFERENCES simulado(id);


--
-- TOC entry 2174 (class 2606 OID 46065)
-- Name: questao resposta_gabarito_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY questao
    ADD CONSTRAINT resposta_gabarito_id FOREIGN KEY (prova_id) REFERENCES prova(id);


-- Completed on 2019-09-12 20:18:02 -03

--
-- PostgreSQL database dump complete
--
