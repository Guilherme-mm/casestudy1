CREATE TABLE t_location (
	id serial4 NOT NULL,
	"city" VARCHAR(255) NOT NULL,
	state VARCHAR(255) NULL,
	country VARCHAR(255) NULL,
	zip_code int4 NOT NULL,
	address VARCHAR(500) NULL,
	item_id int4 NOT NULL,
	CONSTRAINT t_location_pkey PRIMARY KEY (id)
);

ALTER TABLE public.t_location ADD CONSTRAINT t_location_fk FOREIGN KEY (item_id) REFERENCES t_item(id) ON DELETE RESTRICT ON UPDATE CASCADE;