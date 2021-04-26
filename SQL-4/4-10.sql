-- Выведите все данные (*) о тех сотрудниках, у которых в трудовой истории (таблица job_history) есть запись о работе в должности ST_CLERK.
-- Указание: Использование оператора EXISTS.
SELECT * FROM employees
WHERE exists
(SELECT a.* FROM job_history a
WHERE a.employee_id = employees.employee_id 
AND a.job_id = 'ST_CLERK'
)