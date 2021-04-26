-- Выведите все данные (*) о сотрудниках с зарплатой, равной максимальной зарплате внутри своего отдела.
-- Указание: Решите задачу с использованием некоррелированного подзапроса во FROM.
SELECT * FROM employees a
WHERE a.salary = (SELECT MAX(salary) FROM employees b WHERE a.department_id = b.department_id)