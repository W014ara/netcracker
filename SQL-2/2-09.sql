-- Выведите имена и фамилии всех сотрудников (first_name, last_name) и в 3-6 столбцах выведите их зарплату в предположении, что из нее вычли налог 13%, в следующих формах:
-- • low: округленная до целого снизу,
-- • up: округленная до целого сверху,
-- • round_k: округленная до сотен, выраженная в тысячах,
-- • trunk_k: усеченная до сотен, выраженная в тысячах.
-- Пример вывода:
-- FIRST_NAME	LAST_NAME	LOW	UP	ROUND_K	TRUNK_K
-- Arthur	Wilson	20871	20872	20.9	20.8
-- Указание: Использование ROUND, TRUNC, CEIL, FLOOR.
SELECT employees.first_name, employees.last_name, 
(employees.salary - employees.salary*0.13) as low,
trunc(employees.salary-employees.salary*0.13) as up,
ceil(round(employees.salary-employees.salary*0.13, -2))/1000 as round_k,
floor(round(employees.salary-employees.salary*0.13)/100)/10 as trunk_k
FROM employees