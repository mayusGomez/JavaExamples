


CREATE SCHEMA `customer_control` ;

CREATE TABLE `customer_control`.`customer` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_customer`));

INSERT INTO `customer_control`.`customer` (`name`, `lastname`, `email`, `phone`) VALUES ('Jhon', 'Doe', 'jdoe@gmail.com', '345667890');
INSERT INTO `customer_control`.`customer` (`name`, `lastname`, `email`, `phone`) VALUES ('Jhoanna', 'Doe', 'jadoe@hotmail.com', '9990987654');

