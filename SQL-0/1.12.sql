-- Выведите все данные (*) о сотрудниках, которые НЕ находятся в подчинении у менеджеров с id 101 и 102 (включая топ-менеджера)
SELECT * FROM
(SELECT * FROM employees
WHERE employees.manager_id NOT BETWEEN 101 AND 102)
UNION ALL
SELECT * FROM employees
WHERE employees.job_id='AD_PRES'