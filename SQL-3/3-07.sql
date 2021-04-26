-- Выведите максимальное значение средней зарплаты по отделам. Результат округлите до ближайшего целого.
SELECT MAX(ROUND(AVG(salary)))
FROM employees 
GROUP BY department_id