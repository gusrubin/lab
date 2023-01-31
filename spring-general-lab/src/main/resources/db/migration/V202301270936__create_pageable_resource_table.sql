CREATE SEQUENCE pageable_resource_sequence;

CREATE TABLE pageable_resource (
    id int NOT NULL DEFAULT nextval('pageable_resource_sequence'),
    text varchar(500),
    CONSTRAINT pageable_resource_primary_key PRIMARY KEY (id)
);