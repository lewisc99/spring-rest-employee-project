-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spring-rest-employee-project`;

CREATE SCHEMA `spring-rest-employee-project`;
USE `full-stack-ecommerce` ;


-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-rest-employee-project`.`department` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,

  PRIMARY KEY (`id`)


) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-rest-employee-project`.`employee` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `department_id` bigint(20) NOT NULL,
  
  PRIMARY KEY (`id`),
  KEY `fk_department` (`department_id`),
  CONSTRAINT `fk_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `spring-rest-employee-project`.`sales` 
(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(200) NOT NULL,
    `customer_name` varchar(200) NOT NULL,
    `date_created` DATETIME(6) NULL DEFAULT NULL,
    `employee_id` bigint(6) NOT NULL,
    PRIMARY KEY (`id`),
     KEY `fk_employee` (`employee_id`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
	
    

)
ENGINE=InnoDB
AUTO_INCREMENT = 1;

