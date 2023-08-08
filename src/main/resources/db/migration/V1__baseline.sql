SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE SCHEMA IF NOT EXISTS mono_stat;


CREATE TABLE IF NOT EXISTS mono_stat.statements (
  id                VARCHAR(30) NOT NULL PRIMARY KEY,
  time              TIMESTAMP WITHOUT TIME ZONE,
  description       VARCHAR(255),
  mcc               INTEGER,
  original_mcc      INTEGER,
  amount            INTEGER,
  operation_amount  INTEGER,
  currency_code     VARCHAR(3),
  commission_rate   INTEGER,
  cashback_amount   INTEGER,
  balance           INTEGER,
  hold              BOOLEAN,
  receipt_id        VARCHAR(25)
);
