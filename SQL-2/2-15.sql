-- Выведите всю информацию о сотрудниках, фамилии которых начинаются с H или K, содержат 2 одинаковые буквы подряд,
-- а оставшаяся после повторяющихся букв часть фамилии не заканчивается на букву s.
-- Указание: Использование REGEXP_LIKE.
SELECT * FROM employees
WHERE REGEXP_LIKE(employees.last_name,'^(H|K)')
AND REGEXP_LIKE(employees.last_name, '(.)\1+')
AND REGEXP_LIKE(employees.last_name, '[^s]$')