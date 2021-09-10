create table singer
(
    id serial not null,
    first_name varchar(60) not null,
    last_name varchar(40) not null,
    birth_date date,
    unique (first_name, last_name),
    primary key (id)
);

create table album
(
    id           serial       not null,
    singer_id    int          not null,
    title        varchar(100) not null,
    release_date date,
    unique (singer_id, title),
    primary key (id),
    foreign key (singer_id) references singer (id)
)