-- Выведите имена и фамилии всех сотрудников (first_name, last_name) и в 3-7 столбцах выведите размер их комиссионных (commission_pct * salary) или 0, если они отсутствуют, -
-- пятью различными способами: с помощью функций NVL, COALESCE, NVL2, DECODE, CASE.
SELECT employees.first_name, employees.last_name,
NVL(employees.commission_pct * employees.salary, '0') as nvl,
COALESCE(employees.commission_pct * employees.salary, 0) as coalesce,
NVL2 (employees.commission_pct, employees.commission_pct * employees.salary, 0) as nvl2,
DECODE (employees.commission_pct * employees.salary,  null, 0, employees.commission_pct * employees.salary, employees.commission_pct * employees.salary ) as decode,
CASE WHEN employees.commission_pct is null THEN 0
   ELSE employees.commission_pct*employees.salary END as case
FROM employees