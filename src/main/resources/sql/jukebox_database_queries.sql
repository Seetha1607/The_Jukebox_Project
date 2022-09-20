create DATABASE IF NOT EXISTS `jukebox`;

USE `jukebox`;

create TABLE IF NOT EXISTS `jukebox`.`song`
(
  `serial_number` int not null primary key auto_increment,
  `song_name` varchar(60) not null,
  `duration` time not null
);
