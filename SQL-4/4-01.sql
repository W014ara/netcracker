-- Выведите все данные (*) о сотрудниках с зарплатой, равной максимальной зарплате по всей компании. Указание: использовать только таблицу employees.
SELECT * FROM employees
WHERE employees.salary = (SELECT MAX(salary) FROM employees)