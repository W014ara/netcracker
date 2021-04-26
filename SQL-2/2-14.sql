-- Предположим, что значение '$1,250' соответствует одной единице зарплаты (здесь число в американском формате - запятая отделяет тысячи, а не дробную часть).
-- Выведите для тех сотрудников, у кого есть комиссионные:
-- 1) числовое значение зарплаты в указанных единицах;
-- 2) сумму комиссионных в виде строки с префиксом '$' (например, '$3,456'; колонка commission_pct - это доля зарплаты, начисляемая в качестве комиссионных);
-- 3) commission_pct в виде строки в формате '0.12'.
-- Ведущих и хвостовых пробелов быть не должно.
-- Для каждого столбца используйте только функцию преобразования типов (для первого столбца - TO_NUMBER). см. также Format Models.

-- Пример:
-- ITEMS	COMM	COMM_PCT
-- 11.2	$5,600	0.40
-- 5.76	$720	0.10
SELECT 
TO_NUMBER(employees.salary/1250, '9999.99') as items,
TRIM(both ' '  from (to_char(employees.commission_pct*employees.salary, 'L99,999'))) as comm,
TRIM(both ' ' from (to_char(employees.commission_pct, '0.99'))) as comm_pct
FROM employees
WHERE commission_pct is not null