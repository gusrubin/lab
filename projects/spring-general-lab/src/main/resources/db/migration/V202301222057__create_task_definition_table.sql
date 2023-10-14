CREATE SEQUENCE task_definition_sequence;

CREATE TABLE task_definition (
    id int NOT NULL DEFAULT nextval('task_definition_sequence'),
    cron_expression varchar(255),
    action_type varchar(50),
    data varchar(500),
    CONSTRAINT task_definition_primary_key PRIMARY KEY (id)
);