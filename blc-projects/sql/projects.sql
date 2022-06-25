SET foreign_key_checks=0;

DROP TABLE IF EXISTS `TEAM`;
CREATE TABLE `TEAM`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `teamName` VARCHAR(36) NOT NULL,
    `teamInfo` TEXT NOT NULL,
    `teamMember` TEXT NOT NULL ,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `PROJECT`;
CREATE TABLE `PROJECT`
(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `projectName` VARCHAR(36) NOT NULL,
    `synopsis` TEXT DEFAULT NULL,
    `otherInfo` TEXT DEFAULT NULL,
    `history_record` TEXT DEFAULT NULL,
    `current_progress` TEXT DEFAULT NULL,
    `teamId` BIGINT(20) unsigned NOT NULL,
    CONSTRAINT fk_team FOREIGN KEY (teamId) REFERENCES TEAM(`id`),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `TAG`;
CREATE TABLE `TAG`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `tagName` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `PROJECTTAGS`;
CREATE TABLE `PROJECTTAGS`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `pid` bigint(20) unsigned NOT NULL,
    `tid` bigint(20) unsigned NOT NULL,
    CONSTRAINT fk_paper FOREIGN KEY(`pid`) REFERENCES PROJECT(`id`),
    CONSTRAINT fk_tags FOREIGN KEY(`tid`) REFERENCES TAG(`id`),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET foreign_key_checks=1;

INSERT INTO TAG(id,`tagName`) VALUES (null,'项目标签1');
INSERT INTO TAG(id,`tagName`) VALUES (null,'项目标签2');
INSERT INTO TAG(id,`tagName`) VALUES (null,'项目标签3');
INSERT INTO TAG(id,`tagName`) VALUES (null,'项目标签4');
INSERT INTO TAG(id,`tagName`) VALUES (null,'项目标签5');

INSERT INTO TEAM(id, teamName, teamInfo, teamMember) VALUES (null,'研究小组A','研究小组A团队介绍，研究小组A团队介绍，研究小组A团队介绍，研究小组A团队介绍，研究小组A团队介绍，研究小组A团队介绍研究小组A团队介绍研究小组A团队介绍，研究小组A团队介绍','研究小组A成员1；研究小组A成员2；研究小组A成员3');
INSERT INTO TEAM(id, teamName, teamInfo, teamMember) VALUES (null,'研究小组B','研究小组B团队介绍，研究小组B团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，','研究小组B成员1；研究小组B成员2；研究小组B成员3');
INSERT INTO TEAM(id, teamName, teamInfo, teamMember) VALUES (null,'研究小组C','研究小组C团队介绍，研究小组C团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，','研究小组C成员1；研究小组C成员2；研究小组C成员3');
INSERT INTO TEAM(id, teamName, teamInfo, teamMember) VALUES (null,'研究小组D','研究小组D团队介绍，研究小组D团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，','研究小组D成员1；研究小组D成员2；研究小组D成员3');
INSERT INTO TEAM(id, teamName, teamInfo, teamMember) VALUES (null,'研究小组E','研究小组E团队介绍，研究小组B团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，团队介绍团队介绍团队介绍，','研究小组E成员1；研究小组E成员2；研究小组E成员3');

INSERT INTO PROJECT(id, projectName, synopsis, otherInfo, history_record, current_progress, teamId) VALUES (null,'门户网站设计实现毕设项目','我们的汽车救援APP，是一款网络化的救援软件。它只需要安装在你的手机并且实名注册，在你遇到麻烦时只要按照提示点击你所需要的服务并且确定，我们将会为你定位，就近为你派出救援队，让你少些等待！','项目与XXX公司合作；曾获XXXX投资；曾获XXX奖项','这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录','设计阶段，实现阶段迭代一，这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案',1);
INSERT INTO PROJECT(id, projectName, synopsis, otherInfo, history_record, current_progress, teamId) VALUES (null,'计算机综合工作室项目','我们的汽车救援APP，是一款网络化的救援软件。它只需要安装在你的手机并且实名注册，在你遇到麻烦时只要按照提示点击你所需要的服务并且确定，我们将会为你定位，就近为你派出救援队，让你少些等待！','项目与XXX公司合作；曾获XXXX投资；曾获XXX奖项','这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录','设计阶段，实现阶段迭代一，这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案',2);
INSERT INTO PROJECT(id, projectName, synopsis, otherInfo, history_record, current_progress, teamId) VALUES (null,'关于3D全息投影在临床教学中的应用','我们的汽车救援APP，是一款网络化的救援软件。它只需要安装在你的手机并且实名注册，在你遇到麻烦时只要按照提示点击你所需要的服务并且确定，我们将会为你定位，就近为你派出救援队，让你少些等待！','项目与XXX公司合作；曾获XXXX投资；曾获XXX奖项','这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录，这里是历史进展记录','设计阶段，实现阶段迭代一，这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案这里是预留文案，这里是预留文案',3);

INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,1,1);
INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,1,3);
INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,2,1);
INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,2,4);
INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,3,2);
INSERT INTO PROJECTTAGS(id, pid, tid) VALUES (null,3,3);