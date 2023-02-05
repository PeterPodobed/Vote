CREATE TABLE IF NOT EXISTS public.genres
(
    id bigint NOT NULL,
    namegenre character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT genres_pkey PRIMARY KEY (id)
)