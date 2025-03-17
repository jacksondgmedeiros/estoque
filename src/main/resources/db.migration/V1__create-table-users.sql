CREATE TABLE(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    nome character varying(100)[] NOT NULL,
    userName character varying(50)[] NOT NULL,
    password character VARYING(200)[] NOT NULL,
    ativo boolean,
    PRIMARY KEY (id);
)