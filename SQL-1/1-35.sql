-- Вывести почтовый код отдела, в котором работает сотрудник по фамилии 'Sully'.
SELECT postal_code
FROM departments d, employees e, locations l
WHERE d.department_id = e.department_id
AND d.location_id = l.location_id
AND d.department_id = e.department_id
AND last_name = 'Sully'