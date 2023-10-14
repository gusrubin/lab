CREATE SEQUENCE example_id_sequence;
CREATE TABLE example
(
   id int8 NOT NULL DEFAULT nextval ('example_id_sequence'),
   content varchar (255),
   CONSTRAINT example_primary_key PRIMARY KEY (id)
);