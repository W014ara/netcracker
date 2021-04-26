-- Выведите все данные (*) о сотрудниках с зарплатой, равной максимальной зарплате внутри своего отдела.
-- Указание: Решите задачу с использованием коррелированного подзапроса.
SELECT * FROM employees a
WHERE a.salary = (SELECT MAX(salary) FROM employees b WHERE a.department_id = b.department_id)