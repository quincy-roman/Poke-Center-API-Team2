drop table pokemon cascade;

CREATE table trainer(
	trainerid serial primary key,
	firstname varchar(100) not null
);

create table pokemon(
	nationalid serial primary key,
	pokemonname varchar(100) not null unique,
	type1 varchar(100) not null,
	type2 varchar(100),
	ability varchar(100) not null,
	category varchar(100) not null
);

create table meds(
	medid serial primary key,
	medname varchar(100) not null,
	cost numeric not null
	--, statusid numeric
);

create table role(
	roleid serial primary key,
	
);

create table patient(
	pateintid serial primary key,
	nationalid integer not null,
	trainerid integer not null,
	statusid integer not null,
	nurseid integer not null,
	FOREIGN KEY (nationalid) REFERENCES pokemon (nationalid) on delete cascade,
	FOREIGN KEY (trainerid) REFERENCES trainer (trainerid) on delete cascade,
	FOREIGN KEY (statusid) REFERENCES status (statusid) on delete cascade,
	FOREIGN KEY (nurseid) REFERENCES nurse (nurseid) on delete cascade
);

create table nurse(
	nurseid serial primary key,
	firstname varchar(100) not null
);

create table status(
	statusid serial primary key,
	status varchar(100)
);