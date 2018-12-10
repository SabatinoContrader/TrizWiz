-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema contrader
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema contrader
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contrader` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `contrader` ;

-- -----------------------------------------------------
-- Table `contrader`.`abbonamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`abbonamento` (
  `nome` VARCHAR(45) NOT NULL,
  `prezzo` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`badge` (
  `idbadge` INT(11) NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `tipologia` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idbadge`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cognome` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `partitaiva` VARCHAR(45) NULL DEFAULT NULL,
  `ruolo` VARCHAR(45) NULL DEFAULT NULL,
  `nomeAbb` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`),
  INDEX `nomeAbb_idx` (`nomeAbb` ASC) VISIBLE,
  CONSTRAINT `nomeAbb`
    FOREIGN KEY (`nomeAbb`)
    REFERENCES `contrader`.`abbonamento` (`nome`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`assegnazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`assegnazione` (
  `iduser` INT(11) NOT NULL,
  `idbadge` INT(11) NOT NULL,
  `dataassegnazione` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`, `idbadge`),
  INDEX `fk_user_has_badge_badge1_idx` (`idbadge` ASC) VISIBLE,
  INDEX `fk_user_has_badge_user_idx` (`iduser` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_badge_badge1`
    FOREIGN KEY (`idbadge`)
    REFERENCES `contrader`.`badge` (`idbadge`),
  CONSTRAINT `fk_user_has_badge_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `contrader`.`user` (`iduser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`asset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`asset` (
  `idasset` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  `prezzo` DOUBLE NULL DEFAULT NULL,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idasset`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`badgereader`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`badgereader` (
  `idbadgereader` INT(11) NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `tipologia` VARCHAR(45) NULL DEFAULT NULL,
  `idasset` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idbadgereader`),
  INDEX `fk_badgereader_asset1_idx` (`idasset` ASC) VISIBLE,
  CONSTRAINT `idasset`
    FOREIGN KEY (`idasset`)
    REFERENCES `contrader`.`asset` (`idasset`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`movimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`movimento` (
  `idbadgereader` INT(11) NOT NULL,
  `idbadge` INT(11) NOT NULL,
  `datainizio` DATETIME NOT NULL,
  `datafine` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`idbadgereader`, `idbadge`, `datainizio`),
  INDEX `fk_badgereader_has_badge_badge1_idx` (`idbadge` ASC) VISIBLE,
  INDEX `fk_badgereader_has_badge_badgereader1_idx` (`idbadgereader` ASC) VISIBLE,
  CONSTRAINT `fk_badgereader_has_badge_badge1`
    FOREIGN KEY (`idbadge`)
    REFERENCES `contrader`.`badge` (`idbadge`),
  CONSTRAINT `fk_badgereader_has_badge_badgereader1`
    FOREIGN KEY (`idbadgereader`)
    REFERENCES `contrader`.`badgereader` (`idbadgereader`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`prenotazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`prenotazione` (
  `iduser` INT(11) NOT NULL,
  `idasset` INT(11) NOT NULL,
  `orainizio` VARCHAR(45) NOT NULL,
  `orafine` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`, `idasset`, `orainizio`),
  INDEX `fk_prenotazione_asset1_idx` (`idasset` ASC) VISIBLE,
  CONSTRAINT `fk_prenotazione_asset1`
    FOREIGN KEY (`idasset`)
    REFERENCES `contrader`.`asset` (`idasset`),
  CONSTRAINT `fk_prenotazione_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `contrader`.`user` (`iduser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`storico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`storico` (
  `idstorico` INT(11) NOT NULL AUTO_INCREMENT,
  `iduser` INT(11) NULL DEFAULT NULL,
  `idasset` INT(11) NULL DEFAULT NULL,
  `orainizio` DATETIME NULL DEFAULT NULL,
  `orafine` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`idstorico`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader`.`userasset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader`.`userasset` (
  `iduser` INT(11) NOT NULL,
  `idasset` INT(11) NOT NULL,
  `orainizio` DATETIME NOT NULL,
  `orafine` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`, `idasset`, `orainizio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
