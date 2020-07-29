DROP DATABASE IF EXISTS heartDiary;

CREATE DATABASE heartDiary;

USE heartDiary;

# 회원
CREATE TABLE `member`(
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    loginId CHAR(50) NOT NULL,
    loginPw CHAR(50) NOT NULL,
    nickName CHAR(50) NOT NULL
);

ALTER TABLE `heartDiary`.`member` ADD UNIQUE INDEX (`loginId`);
    
# 일기장
CREATE TABLE `diary`(
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` CHAR(100) NOT NULL
);

INSERT INTO `diary`
SET regDate = NOW(),
memberId = 1,
title = '제목1',
`body` = '내용';

INSERT INTO `member`
SET regDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
nickName = '고양이';

INSERT INTO `member`
SET regDate = NOW(),
loginId = '1234',
loginPw = '1234',
nickName = '고호양이';

    
    