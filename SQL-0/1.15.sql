-- Выведите все данные (*) о сотрудниках, должность которых (job_id) записана в следующем формате: [A<любой символ>_<любая последовательность символов>].
-- Указание: Использование оператора like.
SELECT * FROM employees
WHERE employees.job_id LIKE 'A%_%'