-- MySQL Workbench Forward Engineering
drop schema if exists `ssafit`;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8mb4 ;

USE `ssafit` ;
-- -----------------------------------------------------
-- Table `ssafit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `userId` VARCHAR(16) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `score` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `ssafit`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`article` (
  `articleId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `isChecked` TINYINT NOT NULL DEFAULT 0,
  `isPublic` TINYINT NOT NULL DEFAULT 0,
  `image` VARCHAR(255) NOT NULL,
  `orgImage` VARCHAR(255) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `liked` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`articleId`) ,
  CONSTRAINT `fk_article_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafit`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`articleComment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`articleComment` (
  `commentId` INT NOT NULL AUTO_INCREMENT,
  `articleId` INT NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentId`),
  CONSTRAINT `fk_articleComment_article`
    FOREIGN KEY (`articleId`)
    REFERENCES `ssafit`.`article` (`articleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_articleComment_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafit`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`video` (
  `videoId` VARCHAR(255) NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `type` VARCHAR(32) NOT NULL,
  `channelName` VARCHAR(32) NOT NULL,
  `viewCnt` INT NOT NULL default 0,
  `url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`videoId`),
  CONSTRAINT `fk_video_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafit`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `ssafit`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`review` (
  `reviewId` INT NOT NULL AUTO_INCREMENT,
  `videoId` VARCHAR(255) NOT NULL,
  `userId` VARCHAR(32) NOT NULL,
  `title` VARCHAR(32) NOT NULL,
  `writer` VARCHAR(32) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `content` VARCHAR(255) NOT NULL,
  `viewCnt` INT NOT NULL,
  PRIMARY KEY (`reviewId`),
  CONSTRAINT `fk_review_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafit`.`user` (`userId`),
  CONSTRAINT `fk_review_video`
    FOREIGN KEY (`videoId`)
    REFERENCES `ssafit`.`video` (`videoId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `ssafit`.`heart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`heart` (
  `heartId` INT NOT NULL AUTO_INCREMENT,
  `articleId` INT NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`heartId`),
  CONSTRAINT `fk_article_id`
    FOREIGN KEY (`articleId`)
    REFERENCES `ssafit`.`article` (`articleId`),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafit`.`user` (`userId`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO user (userId, username, email, password)
VALUES ("master", "admin", "ssafy@naver.com", "9999"),
("ssafy", "ssafy", "ssafy@naver.com", "1234"),
("test", "tester", "test@naver.com", "1234");

INSERT INTO video
VALUES  ("gMaB-fG4u4g", "ssafy", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "운동", "ThankyouBUBU", 0,
            "https://www.youtube.com/embed/gMaB-fG4u4g"),
        ("swRNeYw1JkY", "ssafy", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "운동", "ThankyouBUBU", 0,
            "https://www.youtube.com/embed/swRNeYw1JkY"),
        ("54tTYO-vU2E", "ssafy", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "운동", "ThankyouBUBU", 0,
            "https://www.youtube.com/embed/54tTYO-vU2E"),
        ("QqqZH3j_vH0", "ssafy", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "운동", "ThankyouBUBU", 0,
            "https://www.youtube.com/embed/QqqZH3j_vH0"),
        ("tzN6ypk6Sps", "ssafy", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "운동", "김강민", 0,
            "https://www.youtube.com/embed/tzN6ypk6Sps"),
        ("u5OgcZdNbMo", "ssafy", "저는 하체 식주의자 입니다", "운동", "GYM종국", 0,
            "https://www.youtube.com/embed/u5OgcZdNbMo"),
        ("PjGcOP-TQPE", "ssafy", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "운동", "ThankyouBUBU", 0,
            "https://www.youtube.com/embed/PjGcOP-TQPE"),
        ("7TLk7pscICk", "ssafy", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "운동", "SomiFit", 0,
            "https://www.youtube.com/embed/7TLk7pscICk");

INSERT INTO review(videoId, userId, title, writer, content, viewCnt)
VALUES 
("gMaB-fG4u4g", "ssafy", "bad", "ssafy", "bad", 0),
("gMaB-fG4u4g", "ssafy", "good", "ssafy", "bad", 0);

INSERT INTO article(userId, title, content, isPublic, image, orgImage, writer)
values 
("ssafy", "야호", "오늘은 등산을 조져봤읍니다.", 1, "이미지~ 속았지롱", "hh", "ssafy"),
("test", "오리", "꽥꽥", 0, "이미지~ 속았지롱", "hh", "tester"),
("test", "언제까지", "테스트 해야대냐", 1, "이미지~ 속았지롱", "hh", "tester"),
("ssafy", "오운완", "오늘은 하체를 조져봤읍니다.", 0, "이미지~ 속았지롱", "hh", "ssafy"),
("test", "런닝머신이...", "고장나서 오늘은 등 함", 0, "이미지~ 속았지롱", "hh", "tester"),
("ssafy", "이것", "오늘은 상체를 조져봤읍니다.", 1, "이미지~ 속았지롱", "hh", "ssafy");

INSERT INTO articleComment(articleId, userId, content)
values (1, "ssafy", "신고합니다.");

SELECT *
FROM video;

SELECT *
FROM user;

SELECT *
FROM review;

SELECT *
FROM article;

select * 
from article
order by regDate desc
limit 4;

select * 
from article
order by regDate desc
limit 4, 8;

SELECT *
FROM articleComment;