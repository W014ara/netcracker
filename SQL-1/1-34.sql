-- Для всех отделов компании вывести название отдела и фамилию (last_name) его менеджера.
-- Если отдел не имеет менеджера, второй столбец должен содержать NULL.
SELECT DISTINCT b.department_name, a.last_name
FROM departments b
LEFT JOIN employees a 
on a.employee_id = b.manager_id