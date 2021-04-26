-- Выведите все номера отделов, в которых состоят сотрудники, и максимальную зарплату по каждому из них.
-- Максимальная зарплата по сотрудникам, не состоящим ни в каком отделе, тоже должна выводиться (номер отдела - null).
SELECT department_id, salary
FROM employees a
WHERE a.salary = ( SELECT MAX(salary) FROM employees b
                    WHERE b.department_id = a.department_id )
UNION
SELECT department_id, salary
FROM employees a
WHERE department_id IS NULL