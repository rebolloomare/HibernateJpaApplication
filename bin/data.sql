DROP TABLE person;

DROP TABLE course;

CREATE TABLE course(
	id integer not null,
	name varchar(255) not null,
	created_date timestamp,
    last_updated_date timestamp,
    is_deleted boolean
    
);

create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   created_date timestamp,
   last_updated_date timestamp,
   primary key(id)
);


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE, CREATED_DATE, LAST_UPDATED_DATE) 
VALUES(10001,  'Omar', 'Mexico',sysdate(),sysdate(),sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE, CREATED_DATE, LAST_UPDATED_DATE)
VALUES(10002,  'James', 'New York',sysdate(),sysdate(),sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE, CREATED_DATE, LAST_UPDATED_DATE) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate(),sysdate(),sysdate());


insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10001,'JPA in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10002,'Spring in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate(),false);