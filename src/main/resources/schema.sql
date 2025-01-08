drop table if exists task;

create table task(
    id int primary key,
    title varchar(50),
    description varchar(50),
    status varchar(50)
);