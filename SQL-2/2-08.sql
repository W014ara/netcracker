-- Выведите имя, фамилию сотрудника, его email и четвертой колонкой — email сотрудника,
-- заменив в нем символы по следующему соответствию: A-a, E-e, I-i, O-o, U-u, Y-y.
-- Указание: Использование TRANSLATE.
SELECT employees.first_name, employees.last_name, employees.email, TRANSLATE(employees.email, 'AEIOUY', 'aeiouy') 
FROM employees