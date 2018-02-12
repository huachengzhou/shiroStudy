CREATE DATABASE IF NOT EXISTS shiro_study CHARACTER SET 'utf-8';

USE shiro_study;

CREATE TABLE sessions (
  id      VARCHAR(200),
  session VARCHAR(2000),
  CONSTRAINT pk_sessions PRIMARY KEY (id)
)
  CHARSET = utf8
  ENGINE = InnoDB;