drop table if exists crypto CASCADE;
create table crypto (id integer generated by default as identity, name varchar(255) not null, abbreviation varchar(255) not null, amount_cryp DOUBLE not null, cost DOUBLE not null, primary key (id));

