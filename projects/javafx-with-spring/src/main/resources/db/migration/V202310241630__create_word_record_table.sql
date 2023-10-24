CREATE SEQUENCE word_record_sequence;

CREATE TABLE word_record (
    id int NOT NULL DEFAULT nextval('word_record_sequence'),
    word varchar(100),
    CONSTRAINT word_record_primary_key PRIMARY KEY (id)
);
