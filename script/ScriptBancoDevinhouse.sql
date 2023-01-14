
CREATE TABLE IF NOT EXISTS public.usuarios
(
    id serial NOT NULL,
    email character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS public.enderecos
(
    id serial NOT NULL,
    cep character varying(10) NOT NULL,
    logradouro character varying(100) NOT NULL,
    numero integer NOT NULL,
    bairro character varying(50) NOT NULL,
    cidade character varying(50) NOT NULL,
    estado character varying(50) NOT NULL,
    complemento character varying(100),
    latitude character varying(20) NOT NULL,
    longitude character varying(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.farmacias
(
    id serial NOT NULL,
    razao_social character varying(100) NOT NULL,
    cnpj character varying(15) NOT NULL,
    nome_fantasia character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    telefone character varying(15),
    celular character varying(15) NOT NULL,
	id_endereco serial,
    PRIMARY KEY (id),
	CONSTRAINT id_endereco FOREIGN KEY(id_endereco) REFERENCES enderecos(id)
);

CREATE TABLE IF NOT EXISTS public.medicamentos
(
    id serial NOT NULL,
    nome_medicamento character varying(50) NOT NULL,
    nome_laboratorio character varying(50) NOT NULL,
    dosagem_medicamento character varying(50) NOT NULL,
    descricao_medicamento character varying(50) NOT NULL,
    preco_unitario character varying(50) NOT NULL,
    tipo_medicamento character varying(50) NOT NULL,
    PRIMARY KEY (id)
);