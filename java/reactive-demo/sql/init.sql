CREATE SCHEMA IF NOT EXISTS my_schema;

CREATE TABLE public.dummytable (
    dummyid SERIAL PRIMARY KEY,
    notes VARCHAR(255)
);