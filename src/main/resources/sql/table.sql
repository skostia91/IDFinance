CREATE SCHEMA `idf`;

CREATE TABLE `idf`.`currency` (
                                  `id` INT NOT NULL AUTO_INCREMENT,
                                  `id_currency` INT NOT NULL,
                                  `symbol` VARCHAR(45) NOT NULL,
                                  `price_usd` DECIMAL(25) NOT NULL,
                                  PRIMARY KEY (`id`));
