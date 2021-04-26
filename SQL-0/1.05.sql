-- По таблице employees, в первом столбце person выведите имя, фамилию сотрудника и id его должности в формате:
-- <имя> <фамилия> (<идентификатор_должности>)
-- (угловые скобки традиционно выделяют то, что не относится к формату вывода, а является данными).
-- Во втором столбце mgr соедините строку: "Mgr's id:" и id менеджера этого сотрудника. Пример вывода:
-- [David Austin (IT_PROG)][Mgr's id:103]
-- Для двух этих столбцов используйте два различных способа конкатенирования строк.
SElECT
COALESCE(employees.first_name, '') ||
COALESCE(' ', '') ||
COALESCE(employees.last_name, '') ||
COALESCE(' ', '') || COALESCE('(', '') ||
COALESCE(employees.JOB_ID, '') ||
COALESCE(')', '') AS person,
CONCAT('Mgr''s id:', '') ||
CONCAT(employees.manager_id, '') as mgr
FROM employees