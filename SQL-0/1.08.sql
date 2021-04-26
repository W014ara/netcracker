-- Выведите все данные (*) о сотрудниках из таблицы employees, у которых нет комиссионных и есть менеджер.
SELECT * FROM employees
WHERE employees.commission_pct IS NULL
AND employees.manager_id IS NOT NULL