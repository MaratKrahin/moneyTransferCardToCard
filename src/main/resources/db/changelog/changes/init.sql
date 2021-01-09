CREATE TABLE card(
ID SERIAL PRIMARY KEY,
   user_id int,
   name VARCHAR(255),
  number VARCHAR(255),
  balance VARCHAR(255));


insert into card(user_id, name, number, balance) values
(1, 'Vasilii', '123-123-123', '1000.000');

insert into card(user_id, name, number, balance) values
(1, 'Vasilii', '555-555-555', '5555000.000');

insert into card(user_id, name, number, balance) values
(2, 'IVAN', '999-999-999', '0');

insert into card(user_id, name, number, balance) values
(3,'EGOR', '777-777-777', '1000.0');
