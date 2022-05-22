create table if not exists STATION
(
    id bigint auto_increment not null,
    name varchar(255) not null,
    deleted BOOLEAN not null,
    primary key(id)
);

create table if not exists LINE
(
    id bigint auto_increment not null,
    name varchar(255) not null,
    color varchar(20) not null,
    extraFare int not null,
    deleted BOOLEAN not null,
    primary key(id)
);

create table if not exists SECTION
(
    id bigint auto_increment not null,
    line_id bigint not null,
    up_station_id bigint not null,
    down_station_id bigint not null,
    distance int,
    deleted BOOLEAN not null,
    primary key(id)
);
