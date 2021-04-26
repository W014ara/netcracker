-- Вывести в первом столбце названия всех отделов компании, а втором - названия стран, где они располагаются.
SELECT departments.department_name, tmp.country_name FROM departments
INNER JOIN
(SELECT countries.country_name, locations.location_id 
FROM countries INNER JOIN locations ON countries.country_id = locations.country_id) tmp
ON tmp.location_id = departments.location_id 