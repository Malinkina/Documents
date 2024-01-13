CREATE TABLE IF NOT EXISTS organization
(
    id         varchar(255) PRIMARY KEY,
    full_name  varchar(255),
    short_name varchar(255),
    manager    varchar(255)
);
CREATE TABLE IF NOT EXISTS position
(
    id          varchar(255) PRIMARY KEY,
    position_id INT,
    "name"      varchar(255)
);
CREATE TABLE IF NOT EXISTS department
(
    id              varchar(255) PRIMARY KEY,
    full_name       varchar(255),
    short_name      varchar(255),
    manager         varchar(255),
    organization_id varchar(255) REFERENCES organization (id)
);
CREATE TABLE IF NOT EXISTS employee
(
    id              varchar(255) PRIMARY KEY,
    surname         varchar(255),
    "name"          varchar(255),
    patronymic      varchar(255),
    photo           varchar(255),
    date_of_birth   varchar(255),
    phone_number    varchar(255),
    department_id   varchar(255) REFERENCES department (id),
    organization_id varchar(255) REFERENCES organization (id),
    position_id     varchar(255) REFERENCES position (id)
);
CREATE TABLE IF NOT EXISTS document
(
    id         varchar(255) PRIMARY KEY,
    doc_id     INT,
    "name"     varchar(255),
    "text"     varchar(255),
    reg_number varchar(255),
    reg_date   Date,
    author_id  varchar(255) REFERENCES employee (id)
);
CREATE TABLE IF NOT EXISTS incoming_document
(
    id                varchar(255) PRIMARY KEY,
    outgoing_number   INT,
    outgoing_reg_date varchar(255),
    recipient_id      varchar(255) REFERENCES employee (id),
    sender_id         varchar(255) REFERENCES employee (id),
    document_id       varchar(255) REFERENCES document (id)
);
CREATE TABLE IF NOT EXISTS outgoing_document
(
    id            varchar(255) PRIMARY KEY,
    delivery_type varchar(255),
    recipient_id  varchar(255) REFERENCES employee (id),
    document_id   varchar(255) REFERENCES document (id)
);
CREATE TABLE IF NOT EXISTS task_document
(
    id                       varchar(255) PRIMARY KEY,
    issue_date               varchar(255),
    execution_term           varchar(255),
    control_mark             boolean,
    responsible_executive_id varchar(255) REFERENCES employee (id),
    controller_id            varchar(255) REFERENCES employee (id),
    document_id              varchar(255) REFERENCES document (id)
);