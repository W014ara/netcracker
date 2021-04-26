-- Для всех отделов, располагающихся в городе 'Seattle', вывести название отдела и номер телефона его менеджера.
-- Если отдел не имеет менеджера, второй столбец должен содержать NULL.
SELECT departments.department_name, employees.phone_number
FROM departments
LEFT JOIN employees ON departments.manager_id = employees.employee_id
INNER JOIN locations ON departments.location_id = locations.location_id
WHERE locations.city = 'Seattle';