DROP TABLE IF EXISTS `all_bet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `all_bet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personId` int(11) DEFAULT NULL,
  `matchId` int(11) DEFAULT NULL,
  `playerId` int(11) DEFAULT NULL,
  `teamId` int(11) DEFAULT NULL,
  `runs` int(11) DEFAULT NULL,
  `wicket` int(11) DEFAULT NULL,
  `over` float DEFAULT NULL,
  `ball` float DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `staticBetRuleId` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_mapping_idx` (`playerId`),
  KEY `match_mapping_idx` (`matchId`),
  KEY `ruleID_mapping_idx` (`staticBetRuleId`),
  CONSTRAINT `match_mapping` FOREIGN KEY (`matchId`) REFERENCES `match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `player_mapping` FOREIGN KEY (`playerId`) REFERENCES `player` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `team_mapping` FOREIGN KEY (`teamId`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_mapping` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ruleID_mapping` FOREIGN KEY (`staticBetRuleId`) REFERENCES `match_bet_applicable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;