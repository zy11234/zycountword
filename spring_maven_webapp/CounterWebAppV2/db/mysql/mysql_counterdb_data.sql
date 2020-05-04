-- Example Database
-- ---------------------
-- Host: localhost      
-- Datebase: counterdb
-- Server Version: 5.7

-- Below is the commnad example to load into MySQL database on Windows.

-- REM change directory to where this SQL script located.
-- cd ${this_project_home}\db\mysql\
--
-- REM login to MySQL as root user using password.
-- mysql -h localhost -u counterdbuser -pCounterDbPasswd1+
--
-- REM source in this script.
-- mysql> source mysql_counterdb_data.sql
-- mysql> quit;

USE `counterdb`;

-- Create tables...
DROP TABLE IF EXISTS `TabCounter`;

CREATE TABLE `TabCounter` (
	`CounterId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`CounterName` TINYTEXT NOT NULL,
	`CounterValue` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY (`CounterId`)
) ENGINE=InnoDB COLLATE='utf8_general_ci';


-- Insert initial data...



COMMIT;
