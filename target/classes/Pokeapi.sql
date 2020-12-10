drop table if exists pokemon cascade;
drop table if exists statuscondition cascade;
drop table if exists meds cascade;
drop table if exists trainer cascade;
drop table if exists patient cascade;
drop table if exists role cascade;
drop table if exists empl cascade;

create table role(
	roleid serial primary key,
	ROLE varchar(100) NOT null
);

insert into "role" ("role") values ('Nurse');
insert into "role" ("role") values ('Admin');

CREATE table trainer(
	trainerid integer primary key,
	firstname varchar(100) not null,
	hometown varchar(100) not null,
	username varchar(100) not null unique,
	password varchar(100) not null
);

INSERT into trainer values (3, 'Brendan', 'Littleroot Town', 'Sapphire', 'Ruby');
INSERT into trainer values (4, 'Lucas', 'Twinleaf Town', 'Diamond', 'Pearl');

create table pokemon(
	dexid integer primary key,
	pokemonname varchar(100) not null unique,
	type1 varchar(100) not null,
	type2 varchar(100),
	ability varchar(100) not null
);

insert into pokemon values (254, 'Sceptile', 'Grass', null, 'Overgrow');
insert into pokemon values (392, 'Infernape', 'Fire', 'Fighting', 'Blaze');

CREATE TABLE statuscondition(
	statusid serial primary key,
	status varchar(100) not null
);

INSERT into statuscondition (status) values ('Burn');
INSERT into statuscondition (status) values ('Freeze');
/*INSERT into statuscondition (status) values ('Sleep');
INSERT into statuscondition (status) values ('Poison');
INSERT into statuscondition (status) values ('Paralyzes');
INSERT into statuscondition (status) values ('Fainted');*/

create table meds(
	medid serial primary key,
	medname varchar(100) not null,
	cost numeric not null, 
	statusid integer not null,
	FOREIGN KEY (statusid) REFERENCES statuscondition (statusid) on delete cascade
);

INSERT into meds (medname, "cost", statusid) values ('Burn Heal', 250, 1);
INSERT into meds (medname, "cost", statusid) values ('Ice Heal', 250, 2);

create table empl(
	emplid serial primary key,
	name varchar(100) not null,
	username varchar(100) not null unique,
	password varchar(100) not null,
	roleid integer not null,
	FOREIGN KEY (roleid) REFERENCES role (roleid) on delete cascade
);

INSERT into empl (name, username, password, roleid) values ('Joy', 'J', 'J', 1);

create table patient(
	pateintid serial primary key,
	dexid integer not null,
	trainerid integer not null,
	admission timestamp,
	currenthp integer not null,
	maxhp integer not null,
	statusid integer not null,	
	nurseid integer, --assigned caretaker
	medid integer, --meds applied
	healthy bool,	
	release timestamp,
	FOREIGN KEY (dexid) REFERENCES pokemon (dexid) on delete cascade,
	FOREIGN KEY (trainerid) REFERENCES trainer (trainerid) on delete cascade,
	FOREIGN KEY (statusid) REFERENCES statuscondition (statusid) on delete cascade,
	FOREIGN KEY (nurseid) REFERENCES empl (emplid) on delete cascade,
	FOREIGN KEY (medid) REFERENCES meds (medid) on delete cascade
);

insert into patient (
dexid, trainerid, 
admission, currenthp, maxhp, statusid,
healthy
) values (
254, 3, 
current_timestamp, 100, 254, 1,
false
);

insert into patient (
dexid, trainerid, 
admission, currenthp, maxhp, statusid,
healthy
) values (
392, 4, 
current_timestamp, 150, 200, 2,
false
);

select * from patient p ;
SELECT * from pokemon p ;

update patient set nurseid = 1 where pateintid =1;
update patient set medid = 1 where pateintid =1;
update patient set healthy = TRUE where pateintid =1;
update patient set "release" = current_timestamp where pateintid =1;