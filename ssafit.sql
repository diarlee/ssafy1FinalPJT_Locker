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
  `isPublic` TINYINT NOT NULL,
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
  `writer` VARCHAR(45),
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
  `viewCnt` INT NOT NULL default 0,
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

INSERT INTO user (userId, username, email, password, score)
VALUES ("master", "admin", "ssafy@naver.com", 9999, 10000),
("cha",	"차은우",	"cha@ssafy.com", 1234, 30),
("harin", "해린", "harin@ssafy.com", 1234, 100),
("hwang", "hwangminheon", "hwang@ssafy.com", 1234, 500),
("karina",	"카리나",	 "karina@ssafy.com", 1234, 1000),
("son", "손흥민",	 "son@ssafy.com", 1234, 0),
("suzy", "수지", "suzy@ssafy.com", 1234, 0);

INSERT INTO video
VALUES  
("5MACh6ylf8g", "master", "운동할때 들으려고 모은 &#39;레전드&#39; 운동노래 모음🎵 [Playlist]", "music", "핏블리 FITVELY", 0, "https://www.youtube.com/embed/5MACh6ylf8g"),
("5pz-VRjffXU", "master", "90%는 잘못된 방법으로 &#39;랫풀다운&#39; 하고 있습니다! (등넓이 가장 빠르게 넓히는 렛풀다운 그립)", "guide", "보통사람을 위한 운동채널",	111, "https://www.youtube.com/embed/5pz-VRjffXU"),
("8nPjlT1VnMA", "master", "'따라갈 생각하지 말고 뛰어넘을 생각해' 운동노래 쇠힙 Playlist", "music", "쥅쥅",	1, "https://www.youtube.com/embed/8nPjlT1VnMA"),
("9kkYi5BsJnE", "master", "𝐏𝐥𝐚𝐲𝐥𝐢𝐬𝐭 운동할 때 텐션🔥 끌어 올려주는 I 걸그룹 케이팝 플레이리스트", "music",	"𝐀𝐦𝐛𝐢𝐞𝐧𝐜𝐞 𝐕𝐢𝐞𝐰 : 휴식공간",	333, "https://www.youtube.com/embed/9kkYi5BsJnE"),
("9WhpAVOSyl8", "master", "하루 딱6분! 다리라인 살리는 운동 [허벅지&amp;엉덩이]", "guide", "Thankyou BUBU",	0, "https://www.youtube.com/embed/9WhpAVOSyl8"),
("asJZXgbU8J0", "master", "어깨 넓어지려면, 하루라도 빨리 &#39;이 운동&#39;시작하세요!!! (프레임 넓혀주는 등운동 루틴/턱걸이/랫풀다운)", "guide", "보통사람을 위한 운동채널", 1, "https://www.youtube.com/embed/asJZXgbU8J0"),
("Hx8Lc_0hUaI", "master", "운동할 시간이 없다는 사람에게 보여주세요... 제발", "guide", "김종국 GYM JONG KOOK", 2, "https://www.youtube.com/embed/Hx8Lc_0hUaI"),
("sup4aPc-IvM", "master", "운동할때 듣기좋은 노래모음 2023(광고X) 진짜 괜찮은 헬스음악, 운동 효과보장!", "music", "운동 음악[Workout Music]", 0, "https://www.youtube.com/embed/sup4aPc-IvM"),
("tzN6ypk6Sps", "master", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]",	"guide", "김강민", 0,	"https://www.youtube.com/embed/tzN6ypk6Sps"),
("U-pNUI_gk9c", "master", "𝐏𝐥𝐚𝐲𝐥𝐢𝐬𝐭 🎧 유산소 40분 걸그룹 플레이리스트 | 운동할 때 듣는 음악 운동플리 🔥 K-pop Playlist | 2023년 걸그룹 플리",	"music", "찡모먼 ⟡", 555,	"https://www.youtube.com/embed/U-pNUI_gk9c"),
("u5OgcZdNbMo", "master", "저는 하체 식주의자 입니다", "guide", "GYM종국", 222, "https://www.youtube.com/embed/u5OgcZdNbMo"),
("VhC7ujGgnwk", "master", "운동 할때 듣기 좋은 노래 💪 신나는 팝송 플리 모음 | Design making tutorial",	"music", "Blue rain", 0, "https://www.youtube.com/embed/VhC7ujGgnwk"),
("VhrSqPx9npY", "master", "여러분! 공 하나만 있어도 드리블 연습 겁나 잘 할 수 있어!", "guide",	"전태풍 Taepoong Chon", 444, "https://www.youtube.com/embed/VhrSqPx9npY"),
("ySCSNVnAeFU", "master", "[가슴루틴] 윗가슴 부터 채우는 가슴운동 루틴 순서/셋트/무게", "guide",	"핏블리 FITVELY", 0, "https://www.youtube.com/embed/ySCSNVnAeFU");


INSERT INTO review(videoId, userId, title, writer, content, viewCnt)
VALUES 
("VhrSqPx9npY", "son", "형", "손흥민", "축구랑 농구 뜨자", 0);

INSERT INTO article(userId, title, writer, content, ischecked, isPublic, image, orgImage, liked)
values 
("son",	"월드컵 예선 중국전", "손흥민", "3 : 0 승리 ~~ 대한민국 화이팅 !!!", 1, 1, "1700754582501_son.jpg", "son.jpg", 100),
("suzy", "마라톤", "수지" ,"힘들어유", 1, 1, "1700754743196_suzy.jpg", "suzy.jpg", 99),
("cha",	"농구",	"차은우", "잘하고싶다 ㅠ 많이 보러 와주세요 ~",	1, 1, "1700755660593_ChaEunwoo.jpg", "ChaEunwoo.jpg", 100),
("karina", "오늘 목표",	"카리나", "스쿼트 200개. 맛있는 거 많이 먹으려면 운동 필수", 1,	1, "1700755922458_karina.jpg", "karina.jpg", 99);

INSERT INTO articleComment(articleId, userId, content)
values (4, "son", "카리나 개이쁘다");

-- SELECT *
-- FROM video;

-- SELECT *
-- FROM user;

-- SELECT *
-- FROM review;

SELECT *
FROM article;

-- SELECT *
-- FROM articleComment;