-- Выведите в одну строчку: максимальную, среднюю и минимальную зарплату, суммарную зарплату,
-- количество сотрудников и количество отделов, в которых состоят сотрудники.
-- Все значения вычисляйте по всем сотрудникам таблицы employees
SELECT MAX(salary), AVG(salary), MIN(salary), SUM(salary), COUNT(employee_id), COUNT(UNIQUE(DEPARTMENT_ID)) FROM employees