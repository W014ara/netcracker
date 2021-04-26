-- Для отдела с id = 50 выведите должности, занимаемые его сотрудниками.
-- В каждой строке выведите: должность (job_id) и максимальную зарплату сотрудников отдела в этой должности.
-- Результат отсортируйте по максимальной зарплате в порядке возрастания.
-- Указание: используйте только таблицу employees
SELECT job_id, MAX(salary) "salary" FROM employees WHERE department_id = 50
GROUP BY job_id 
ORDER BY "salary"