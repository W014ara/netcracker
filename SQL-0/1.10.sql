-- Выведите все данные (*) о сотрудниках, которые находятся в подчинении у менеджеров со следующими id: 100, 101, 102.
SELECT * FROM employees
WHERE employees.manager_id BETWEEN 100 AND 102