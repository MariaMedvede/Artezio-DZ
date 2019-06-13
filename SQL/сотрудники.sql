#Задание 1
CREATE DATABASE IF NOT EXISTS СотрудникиИнфо;
USE СотрудникиИнфо;
CREATE TABLE IF NOT EXISTS сотрудники (
id INT unsigned NOT NULL auto_increment primary key,
Имя VARCHAR(30) NOT NULL,
Фамилия VARCHAR(30) NOT NULL,
Зарплата int
);
 INSERT INTO сотрудники ( id, Имя, Фамилия, Зарплата) VALUES ( null, 'Иван', 'Иванов', 45000);
INSERT INTO сотрудники ( id, Имя, Фамилия, Зарплата) VALUES ( null, 'Алексей', 'Петров', 30000);
INSERT INTO сотрудники ( id, Имя, Фамилия, Зарплата) VALUES ( null, 'Дарья', 'Алексеева',  25000);
INSERT INTO сотрудники ( id, Имя, Фамилия, Зарплата) VALUES ( null, 'Анастасия', 'Демина',  25000);
INSERT INTO сотрудники ( id, Имя, Фамилия, Зарплата) VALUES ( null, 'Мария', 'Казакова',  26000);
  
  CREATE TABLE IF NOT EXISTS должность (
id INT UNSIGNED NOT NULL AUTO_INCREMENT primary key,
название_должности VARCHAR(20)
);
INSERT INTO должность (id, название_должности) VALUES (null, 'директор');
INSERT INTO должность (id, название_должности) VALUES (null, 'программист');
INSERT INTO должность (id, название_должности) VALUES (null, 'бизнес-аналитик');
INSERT INTO должность (id, название_должности) VALUES (null, 'менеджер');

ALTER TABLE сотрудники ADD position_id INTEGER NOT NULL;
UPDATE сотрудники SET position_id=1 WHERE id=1;
UPDATE сотрудники SET position_id=2 WHERE id=2;
UPDATE сотрудники SET position_id=3 WHERE id=5;
UPDATE сотрудники SET position_id=4 WHERE id IN(3,4);
#Задание 2
SELECT * FROM сотрудники WHERE зарплата <30000;
 SELECT * FROM сотрудники WHERE position_id = 4 AND зарплата <30000; 
 #Задание 3
 use сотрудникиинфо;
 SELECT * FROM сотрудники
JOIN должность ON сотрудники.position_id =должность.id;
CREATE TABLE IF NOT EXISTS boss (
id_employee int,
id_boss int
);
INSERT INTO boss  VALUES (1, 1);
INSERT INTO boss  VALUES (2, 1);
INSERT INTO boss  VALUES (3, 1);
INSERT INTO boss  VALUES (4, 1);
INSERT INTO boss  VALUES (5, 1);
INSERT INTO boss  VALUES (4, 2);
INSERT INTO boss  VALUES (3, 5);

#Посмотрим, какие есть начальники 
select id_boss, Имя, Фамилия from boss
JOIN сотрудники ON сотрудники.id = boss.id_boss;

#Выберем людей, у которых начальник - Казакова 
SELECT Имя, Фамилия FROM сотрудники
JOIN boss ON сотрудники.id =boss.id_employee WHERE boss.id_boss=5;

