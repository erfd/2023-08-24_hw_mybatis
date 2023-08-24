create table table1
(
    id   integer      not null,
    name varchar(255) not null,
    primary key (id)
);

insert into table1 (id, name)
values (1, 'name1')