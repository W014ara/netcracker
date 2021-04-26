-- Выведите название отдела и среднюю зарплату сотрудников в отделе,
-- причем только для отделов, где средняя зарплата больше 5000.
SELECT department_name, AVG(salary)
FROM 
(SELECT department_name, salary
 FROM employees a, departments b
 WHERE b.department_id = a.department_id
)
GROUP BY department_name
HAVING AVG(salary) > 5000