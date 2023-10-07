CREATE TABLE _user
(
    id    serial primary key,
    login         VARCHAR(100) not null,
    pswd varchar(1000) not null
)
