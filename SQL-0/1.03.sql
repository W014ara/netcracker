-- Для сотрудников, у которых есть комиссионные, выведите в столбце sum сумму зарплаты и комиссионных сотрудника
-- (колонка commission_pct обозначает долю зарплаты, начисляемую в качестве комиссионных),
-- и затем все столбцы таблицы employees (*).
-- Результат должен быть отсортирован по sum, потом по четвертому столбцу в итоговой выборке. Указание: перед * использовать имя (или alias) таблицы

SElECT salary+salary*commission_pct as sum, employees.*
FROM employees
WHERE employees.commission_pct IS NOT NULL
ORDER BY sum, employees.last_name