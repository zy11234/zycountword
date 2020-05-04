-- Example Database
-- ---------------------
-- Host: localhost      
-- Datebase: counterdb
-- Server Version: 5.7

-- Below is the commnad example to load into MySQL database on Windows.

-- REM change directory to where this SQL script located.
-- cd ${this_project_home}\db\mysql\

-- REM login to MySQL as root user using password.
-- mysql -h localhost -u root -p
--
-- REM source in this script.
-- mysql> source mysql_counterdb_schema.sql
-- mysql> quit;


-- create a database.
create database counterdb CHARACTER SET utf8 COLLATE utf8_bin;

-- create a user and grant permission.
grant usage on *.* to counterdbuser@localhost identified by 'CounterDbPasswd1+';
grant all privileges on counterdb.* to counterdbuser@localhost;

