create table regions
(
    id   integer      not null,
    name varchar(255) not null,
    slug varchar(10)  not null,
    primary key (id)
);

insert into regions (id, name, slug)
values (76, 'Ярославская область', 'RU-YAR'),
       (77, 'Москва', 'RU-MOW'),
       (78, 'Санкт-Петербург', 'RU-SPB')
;