-- Выведите все данные (*) о сотрудниках с зарплатой не менее 3000, кроме сотрудника с фамилией King.
SELECT * FROM employees
WHERE employees.salary>=3000
AND employees.last_name<>'King'