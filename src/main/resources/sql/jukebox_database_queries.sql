create DATABASE IF NOT EXISTS `jukebox`;

USE `jukebox`;

create TABLE IF NOT EXISTS `jukebox`.`song`
(
  `serial_number` int not null primary key auto_increment,
  `song_name` varchar(60) not null,
  `duration` time not null
);

--Inserted song 1:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('1', 'Believer', '00:03:36');

--Inserted song 2:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('2', 'Dance Monkey', '00:03:29');

--Inserted song 3:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('3', 'Girls Like You', '00:04:30');

--Inserted song 4:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('4', 'Love Yourself', '00:03:52');

--Inserted song 5:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('5', 'Lovely', '00:03:20');

--Inserted song 6:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('6', 'Memories', '00:03:15');

--Inserted song 7:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('7', 'Payphone', '00:03:56');

--Inserted song 8:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('8', 'Perfect', '00:04:39');

--Inserted song 9:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('9', 'Senorita', '00:03:11');

--Inserted song 10:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('10', 'The Weekend - Blinding lights', '00:03:23');

--Inserted song 11:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('11', 'Umbrella', '00:04:39');

--Inserted song 12:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('12', 'Unstoppable', '00:04:06');

--Inserted song 13:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('13', 'We Dont Talk Anymore', '00:03:50');

--Inserted song 14:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('14', 'What Makes You Beautiful', '00:03:26');

--Inserted song 15:
insert into `jukebox`.`song` (`serial_number`, `song_name`, `duration`) VALUES
 ('15', 'Who Says', '00:03:12');

--Select all details from table:
select * from jukebox.song;

--create table called album:
create TABLE IF NOT EXISTS `album`
(
   `album_id` int not null primary key auto_increment,
   `ablum_name` varchar(45) not null,
   `genre` varchar(20) not null,
   `songs` int not null,
    FOREIGN KEY(songs) REFERENCES song(serial_number)
);

--Insert albums accordingly:
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '4',
   'Pop Album',
   'Pop',
   '15'
);

insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '6',
   'Pop Album',
   'Pop',
   '11'
);

insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '7',
   'Soul Album',
   'Soul',
   '3'
);

insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '8',
   'Soul Album',
   'Soul',
   '9'
);

insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '9',
   'Soul Album',
   'Soul',
   '13'
);

insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '10',
   'Soul Album',
   'Soul',
   '10'
);
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '11',
   'Fusion Album',
   'Fusion',
   '7'
);
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '12',
   'Fusion Album',
   'Fusion',
   '14'
);
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '13',
   'Fusion Album',
   'Fusion',
   '6'
);
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '14',
   'Fusion Album',
   'Fusion',
   '8'
);
insert into `jukebox`.`album` (`album_id`, `ablum_name`, `genre`, `songs`) VALUES
(
   '15',
   'Fusion Album',
   'Fusion',
   '5'
);

select album.album_id as 'Album_ID', album.ablum_name AS 'Album_Name', song.song_name AS 'Song_Name' FROM album
JOIN song ON (song.serial_number = album.songs);

