CREATE TABLE IF NOT EXISTS JPAOrganization
(
    id         varchar(255) PRIMARY KEY,
    full_name  varchar(255),
    short_name varchar(255),
    manager    varchar(255)
);
CREATE TABLE IF NOT EXISTS JPAPosition
(
    id          varchar(255) PRIMARY KEY,
    position_id INT,
    "name"      varchar(255)
);
CREATE TABLE IF NOT EXISTS JPADepartment
(
    id              varchar(255) PRIMARY KEY,
    full_name       varchar(255),
    short_name      varchar(255),
    manager         varchar(255),
    organization_id varchar(255) REFERENCES JPAOrganization (id)
);
CREATE TABLE IF NOT EXISTS XMLEmployee
(
    id              varchar(255) PRIMARY KEY,
    surname         varchar(255),
    "name"          varchar(255),
    patronymic      varchar(255),
    photo           varchar(255),
    date_of_birth   varchar(255),
    phone_number    varchar(255),
    department_id   varchar(255) REFERENCES JPADepartment (id),
    organization_id varchar(255) REFERENCES JPAOrganization (id),
    position_id     varchar(255) REFERENCES JPAPosition (id)
);
CREATE TABLE IF NOT EXISTS JPADocument
(
    id         varchar(255) PRIMARY KEY,
    doc_id     INT,
    "name"     varchar(255),
    "text"     varchar(255),
    reg_number varchar(255),
    reg_date   Date,
    author_id  varchar(255) REFERENCES XMLEmployee (id)
);
CREATE TABLE IF NOT EXISTS incoming_document
(
    id                varchar(255) PRIMARY KEY,
    outgoing_number   INT,
    outgoing_reg_date varchar(255),
    recipient_id      varchar(255) REFERENCES XMLEmployee (id),
    sender_id         varchar(255) REFERENCES XMLEmployee (id),
    document_id       varchar(255) REFERENCES JPADocument (id)
);
CREATE TABLE IF NOT EXISTS outgoing_document
(
    id            varchar(255) PRIMARY KEY,
    delivery_type varchar(255),
    recipient_id  varchar(255) REFERENCES XMLEmployee (id),
    document_id   varchar(255) REFERENCES JPADocument (id)
);
CREATE TABLE IF NOT EXISTS task_document
(
    id                       varchar(255) PRIMARY KEY,
    issue_date               varchar(255),
    execution_term           varchar(255),
    control_mark             boolean,
    responsible_executive_id varchar(255) REFERENCES XMLEmployee (id),
    controller_id            varchar(255) REFERENCES XMLEmployee (id),
    document_id              varchar(255) REFERENCES JPADocument (id)
);