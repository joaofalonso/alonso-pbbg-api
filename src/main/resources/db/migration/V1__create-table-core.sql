CREATE TABLE core_base
(
    id    serial primary key,
    name         VARCHAR(100) not null,
    core_element_type varchar(10) not null,
    gold integer not null,
    food integer not null,
    exp decimal(18,2) not null,
    base_level integer not null,
    buildings integer not null,
    units integer not null,
    active boolean not null
);
