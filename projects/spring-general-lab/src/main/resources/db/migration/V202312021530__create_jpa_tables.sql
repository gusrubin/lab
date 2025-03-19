CREATE SEQUENCE person_id_sequence;
CREATE TABLE person (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

CREATE SEQUENCE patient_id_sequence;
CREATE TABLE patient (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE SEQUENCE medical_record_id_sequence;
CREATE TABLE medical_record (
    id BIGINT PRIMARY KEY,
    patient_id BIGINT UNIQUE,
    description_of_last_visit VARCHAR(1000)
);

CREATE SEQUENCE account_id_sequence;
CREATE TABLE account (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(255)
);

CREATE SEQUENCE account_setting_id_sequence;
CREATE TABLE account_setting (
    id BIGINT PRIMARY KEY,
    setting_name VARCHAR(255),
    setting_value VARCHAR(255),
    account_id BIGINT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);
