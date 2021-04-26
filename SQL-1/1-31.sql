-- Вывести названия всех отделов, располагающихся по адресу '2004 Charade Rd'.
SELECT department_name FROM departments
INNER JOIN locations ON locations.location_id = departments.location_id 
AND street_address = '2004 Charade Rd'