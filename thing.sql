CREATE TABLE `amebadevicesdb`.`thing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numUscite` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);