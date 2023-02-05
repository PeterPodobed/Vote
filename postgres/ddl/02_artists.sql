CREATE TABLE IF NOT EXISTS public.artists
(
    id bigint NOT NULL,
    nameartist character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT artists_pkey PRIMARY KEY (id)
)
