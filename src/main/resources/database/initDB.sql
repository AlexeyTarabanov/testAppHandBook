DROP TABLE IF EXISTS handbooks;

CREATE TABLE IF NOT EXISTS handbooks
(
    id           SERIAL PRIMARY KEY,
    title         varchar(100),
    short_title varchar(20)
    );