DROP TABLE IF EXISTS handbooks;

CREATE TABLE IF NOT EXISTS handbooks
(
    id           SERIAL PRIMARY KEY,
    title         varchar(100),
    abbreviation varchar(20)
    );