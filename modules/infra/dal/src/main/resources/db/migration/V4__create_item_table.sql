CREATE TABLE t_item (
	id serial4 NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	category VARCHAR(255) NOT NULL,
	image_url VARCHAR(500) NULL,
	reputation int4 NOT NULL,
	rating int4 NOT NULL,
	reputation_badge VARCHAR(255) NOT NULL,
	price int4 NOT NULL DEFAULT 0,
	availability int4 NOT NULL DEFAULT 0,
	hotelier_id int4 NOT NULL,
	CONSTRAINT t_item_pkey PRIMARY KEY (id)
);

ALTER TABLE public.t_item ADD CONSTRAINT t_item_fk FOREIGN KEY (hotelier_id) REFERENCES t_hotelier(id) ON DELETE RESTRICT ON UPDATE CASCADE;