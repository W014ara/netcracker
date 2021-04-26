-- Выведите имя, фамилию сотрудника и третьей колонкой должность (JOB_ID), заменив в ней встречающиеся символы '_' на '-'.
-- Отсортировать полученные результаты по суммарной длине имени и фамилии, затем по первому и второму столбцу выборки.
-- Указание: Использование LENGTH, REPLACE.
SELECT employees.first_name, employees.last_name, REPLACE(job_id, '_', '-') as job_id FROM employees
ORDER BY (LENGTH(first_name) + LENGTH(last_name)), first_name, last_name