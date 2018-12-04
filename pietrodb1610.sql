CREATE TABLE `amebadevicesdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `datanascita` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_role` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iduser_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

CREATE TABLE `amebadevicesdb`.`building` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `indirizzo` VARCHAR(45) NOT NULL,
  `interno` INT NOT NULL,
  `citta` VARCHAR(45) NOT NULL,
  `cap` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `unique_index_aggregate` (`indirizzo` ASC, `interno` ASC, `cap` ASC, `citta` ASC) VISIBLE);

CREATE TABLE `amebadevicesdb`.`floor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descrizione` VARCHAR(45) NOT NULL,
  `idbuilding` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `idbuilding_idx` (`idbuilding` ASC) VISIBLE,
  CONSTRAINT `idbuilding`
    FOREIGN KEY (`idbuilding`)
    REFERENCES `amebadevicesdb`.`building` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `amebadevicesdb`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descrizione` VARCHAR(45) NULL,
  `idfloor` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `idfloor_idx` (`idfloor` ASC) VISIBLE,
  CONSTRAINT `idfloor`
    FOREIGN KEY (`idfloor`)
    REFERENCES `amebadevicesdb`.`floor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `amebadevicesdb`.`proprieta` (
  `idbuilding` INT NOT NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`idbuilding`, `iduser`),
  INDEX `iduser_idx` (`iduser` ASC) VISIBLE,
  CONSTRAINT `proprietabuilding`
    FOREIGN KEY (`idbuilding`)
    REFERENCES `amebadevicesdb`.`building` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `proprietauser`
    FOREIGN KEY (`iduser`)
    REFERENCES `amebadevicesdb`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

    CREATE TABLE `amebadevicesdb`.`itemtype` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `modello` VARCHAR(45) NOT NULL,
  `descrizione` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `amebadevicesdb`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `seriale` VARCHAR(45) NULL,
  `consumo_energetico` INT NULL,
  `idroom` INT NULL,
  `iditemtype` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `iteminroom_idx` (`idroom` ASC) VISIBLE,
  INDEX `typeofitem_idx` (`iditemtype` ASC) VISIBLE,
  CONSTRAINT `iteminroom`
    FOREIGN KEY (`idroom`)
    REFERENCES `amebadevicesdb`.`room` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `typeofitem`
    FOREIGN KEY (`iditemtype`)
    REFERENCES `amebadevicesdb`.`itemtype` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL);