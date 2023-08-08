CREATE TABLE t_hotelier (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

INSERT INTO t_hotelier (name) values ('Test Hotelier')