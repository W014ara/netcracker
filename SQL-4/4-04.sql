-- Выведите все данные (*) о сотрудниках с зарплатой, равной максимальной зарплате внутри своего отдела.
-- Указание: Решите задачу с использованием некоррелированного подзапроса и оператора IN.
SELECT * FROM employees a
WHERE a.salary IN (SELECT MAX(salary) FROM employees b WHERE a.department_id = b.department_id)