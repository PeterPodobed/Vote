CREATE TABLE IF NOT EXISTS public.vote
(
    id bigint NOT NULL,
    about character varying(255) COLLATE pg_catalog."default",
    artist integer NOT NULL,
    dt_create timestamp without time zone,
    email character varying(255) COLLATE pg_catalog."default",
    genre_1 integer NOT NULL,
    genre_2 integer NOT NULL,
    genre_3 integer NOT NULL,
    genre_4 integer NOT NULL,
    genre_5 integer NOT NULL,
    CONSTRAINT vote_pkey PRIMARY KEY (id)
)
