CREATE DATABASE IF NOT EXISTS disney;
USE disney;

CREATE TABLE IF NOT EXISTS personage
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    image       BLOB NOT NULL,
    name        varchar(255) NOT NULL,
    age         integer  DEFAULT NULL,
    history     varchar(255) NOT NULL,
    weight      float NOT NULL,
    CONSTRAINT UNIQUEP_name UNIQUE (name),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS movie
(
    id                  BIGINT NOT NULL AUTO_INCREMENT,
    image               BLOB NOT NULL,
    title               varchar(255) NOT NULL,
    creation_date       DATE   DEFAULT NULL,
    score               integer NOT NULL,
    CONSTRAINT UNIQUEM_title UNIQUE (title),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS genre
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    image       BLOB NOT NULL,
    name        varchar(255) NOT NULL,
    CONSTRAINT UNIQUEG_name UNIQUE (name),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS personage_movie
(
    personage_id                 BIGINT NOT NULL,
    movie_id                     BIGINT NOT NULL,
    PRIMARY KEY (personage_id, movie_id),

    CONSTRAINT `FK_PERSONAGE_MOVIE` FOREIGN KEY (personage_id)
    REFERENCES personage (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_MOVIE_PERSONAGE` FOREIGN KEY (`movie_id`)
    REFERENCES movie (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS movie_personage
(
    movie_id         BIGINT NOT NULL,
    genre_id         BIGINT NOT NULL,
    PRIMARY KEY (movie_id,genre_id),

    CONSTRAINT `FK_MOVIE_GENRE` FOREIGN KEY (movie_id)
    REFERENCES movie (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_GENRE_MOVIE` FOREIGN KEY (`genre_id`)
    REFERENCES genre (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION

)
