SET foreign_key_checks=0;

DROP TABLE IF EXISTS `PAPERS`;
CREATE TABLE `PAPERS`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name` TEXT NOT NULL,
    `author` VARCHAR(1024) NOT NULL,
    `year` VARCHAR(10) NOT NULL,
    `conference` VARCHAR(1024) NOT NULL,
    `link` VARCHAR(256) DEFAULT NULL,
    `synopsis` TEXT DEFAULT NULL,
    `keywords` TEXT DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `TAGS`;
CREATE TABLE `TAGS`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `tagName` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `PAPERTAGS`;
CREATE TABLE `PAPERTAGS`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `pid` bigint(20) unsigned NOT NULL,
    `tid` bigint(20) unsigned NOT NULL,
    CONSTRAINT fk_paper FOREIGN KEY(`pid`) REFERENCES PAPERS(`id`),
    CONSTRAINT fk_tags FOREIGN KEY(`tid`) REFERENCES TAGS(`id`),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `PERSON`;
CREATE TABLE `PERSON`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `personName` VARCHAR(36) NOT NULL,
    `introduction` TEXT DEFAULT NULL,
    `type` int(11) unsigned NOT NULL DEFAULT 0,
    `link` VARCHAR(36) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET foreign_key_checks=1;
