CREATE TABLE `user` (
  `user_id` INT unsigned NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR (30) NOT NULL,
  `username` VARCHAR (20) NOT NULL UNIQUE,
  `password` VARCHAR (256) NOT NULL,
  `enabled` TINYINT(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `account` (
  `account_id` INT unsigned NOT NULL AUTO_INCREMENT,
  `user_id` INT unsigned NOT NULL,
  `account_number` VARCHAR (10) UNIQUE,
  `credit` DOUBLE,
  PRIMARY KEY (`account_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);