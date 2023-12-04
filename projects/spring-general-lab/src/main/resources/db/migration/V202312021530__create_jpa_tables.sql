CREATE SEQUENCE person_id_sequence;
CREATE TABLE person (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);