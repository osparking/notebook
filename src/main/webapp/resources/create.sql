---- MariaDB 
 -- database: notebook
 -- mysqlD port number: 3306
 -- table name: memo (schema: below)
 -- user ID : myself
 -- user password: 1234
 
CREATE TABLE `memo` (
  `seqNo` mediumint(9) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`seqNo`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;



