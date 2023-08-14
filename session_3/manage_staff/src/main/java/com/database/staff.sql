create database manage_staff;
use manage_staff;
create table brand
(
    id        int auto_increment primary key not null,
    brandName varchar(60)                    not null
);
create table staff
(
    id        int auto_increment primary key not null,
    nameStaff varchar(60)                    not null,
    age       int                            not null,
    salary    double                         not null,
    idBrand   int                            not null,
    foreign key (idBrand) references brand (id)
);
select * from brand;
insert into brand ( brandName) values ('IT');
insert into brand ( brandName) values ('Marketing');
insert into brand ( brandName) values ('Accounting');
insert into brand ( brandName) values ('Audit');
insert into brand ( brandName) values ('Financial');

select * from staff;

insert into  staff ( nameStaff, age, salary, idBrand)
values ('Ace' , 20 , 5000 , 1);


