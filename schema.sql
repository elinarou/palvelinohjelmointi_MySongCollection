SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS instrument;
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS application_user;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE genre
(genre_id BIGINT NOT NULL AUTO_INCREMENT
, genre_name VARCHAR(100) NOT NULL
, PRIMARY KEY (genre_id));

INSERT INTO genre (genre_name)
VALUES ("Country")
, ("Classical")
, ("Electronic")
, ("Heavy metal")
, ("Folk")
, ("Pop")
, ("Rock");

CREATE TABLE instrument
(instru_id BIGINT NOT NULL AUTO_INCREMENT
, instru_name VARCHAR(100) NOT NULL
, PRIMARY KEY (instru_id));

INSERT INTO instrument (instru_name)
VALUES ("Guitar")
, ("Piano")
, ("Ukulele");

CREATE TABLE song (
id BIGINT NOT NULL AUTO_INCREMENT
, song_name VARCHAR(100) NOT NULL
, artist VARCHAR(100) NOT NULL
, url VARCHAR(500) NOT NULL
, genre_id BIGINT
, instru_id BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
, FOREIGN KEY (instru_id) REFERENCES instrument(instru_id));

INSERT INTO song (song_name, artist, url, genre_id, instru_id)
VALUES ("Laulu1", "Muusikko1", "https://1drv.ms/t/s!At_Ns8Y7Yy3piNxnsVPN53NmTH3S2A?e=pqPD06", 4, 1)
, ("Laulu2", "Muusikko2", "https://www.google.com", 1, 2)
, ("Laulu3", "Muusikko3", "https://www.google.com", 6, 3)
, ("Laulu4", "Muusikko4", "https://www.google.com", 6, 3)
, ("Laulu5", "Muusikko5", "https://www.google.com", 1, 1);

CREATE TABLE application_user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, firstname VARCHAR(100) NOT NULL
, lastname VARCHAR(100) NOT NULL
, role_status VARCHAR(100) NOT NULL
, username VARCHAR(250) NOT NULL
, password_hash VARCHAR(250) NOT NULL);

INSERT INTO application_user (firstname, lastname, role_status, username, password_hash)
VALUES ("Maija", "Meikäläinen", "USER", "user",
"$2a$10$57kg9OGuj44FPQyaps/fvOHmP845GQHIFdjphY4ILU/LoF1sVnQPS"),
("Elina", "Rouvinen", "ADMIN", "admin",
"$2a$10$7DJe9e5TiHD5hHpm029KKeVXE/waBITs/9ykEd1qhEfZZbaRVkRiW");

SELECT * FROM song;
SELECT * FROM genre;
SELECT * FROM instrument;
SELECT * FROM application_user;