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

CREATE table trainer(
	trainerid integer primary key,
	firstname varchar(100) not null,
	hometown varchar(100) not null,
	roleid integer not null,
	FOREIGN KEY (roleid) REFERENCES role (roleid) on delete cascade
);

create table pokemon(
	nationalid integer primary key,
	pokemonname varchar(100) not null unique,
	type1 varchar(100) not null,
	type2 varchar(100),
	ability varchar(100) not null,
	category varchar(100) not null
);

CREATE TABLE statuscondition(
	statusid serial primary key,
	status varchar(100) not null
);

create table meds(
	medid serial primary key,
	medname varchar(100) not null,
	cost numeric not null, 
	statusid integer not null,
	FOREIGN KEY (statusid) REFERENCES statuscondition (statusid) on delete cascade
);

create table empl(
	emplid serial primary key,
	name varchar(100) not null,
	roleid integer not null,
	FOREIGN KEY (roleid) REFERENCES role (roleid) on delete cascade
);

create table patient(
	pateintid serial primary key,
	nationalid integer not null,
	currenthp integer not null,
	maxhp integer not null,
	statusid integer not null,	
	trainerid integer not null,
	nurseid integer, --assigned caretaker
	medid integer, --meds applied
--	nurseid integer not null,
	FOREIGN KEY (nationalid) REFERENCES pokemon (nationalid) on delete cascade,
	FOREIGN KEY (trainerid) REFERENCES trainer (trainerid) on delete cascade,
	FOREIGN KEY (statusid) REFERENCES statuscondition (statusid) on delete cascade,
	FOREIGN KEY (nurseid) REFERENCES empl (emplid) on delete cascade,
	FOREIGN KEY (medid) REFERENCES meds (medid) on delete cascade
);

INSERT into statuscondition (status) values ('Burn');
INSERT into statuscondition (status) values ('Freeze');

INSERT into meds (medname, "cost", statusid) values ('Burn Heal', 250, 1);
INSERT into meds (medname, "cost", statusid) values ('Ice Heal', 250, 2);

insert into pokemon values (254, 'Sceptile', 'Grass', null, 'Overgrow', 'Forest');
insert into pokemon values (392, 'Infernape', 'Fire', 'Fighting', 'Blaze', 'Flame');

insert into "role" ("role") values ('Trainer');
insert into "role" ("role") values ('Nurse');

INSERT into trainer values (3, 'Brendan', 'Littleroot Town', 1);
INSERT into trainer values (4, 'Lucas', 'Twinleaf Town', 1);

INSERT into empl (name, roleid) values ('Joy', 2);

insert into patient (nationalid, statusid, trainerid, currenthp, maxhp) values (254, 1, 3, 100, 254);
insert into patient (nationalid, statusid, trainerid, currenthp, maxhp) values (392, 2, 4, 150, 200);

select * from patient p ;

update patient set statusid = 2 WHERE pateintid = 2;
update patient set nurseid = 1 where pateintid = 1;
update patient set medid = 1 where pateintid = 1;
