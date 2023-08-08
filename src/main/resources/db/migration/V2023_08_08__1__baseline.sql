SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE SCHEMA mono_stat;


CREATE TABLE mono_stat.statements (
  id                VARCHAR(30) NOT NULL PRIMARY KEY,
  time              TIMESTAMP WITHOUT TIME ZONE,
  description       VARCHAR(255),
  mcc               INTEGER,
  originalMcc       INTEGER,
  amount            INTEGER,
  operationAmount   INTEGER,
  currencyCode      INTEGER,
  commissionRate    INTEGER,
  cashbackAmount    INTEGER,
  balance           INTEGER,
  hold              BOOLEAN,
  receiptId         VARCHAR(25)
);
