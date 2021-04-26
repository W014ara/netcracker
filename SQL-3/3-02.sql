-- Посчитайте количество сотрудников, у кого есть комиссионные, средние комиссионные среди всех сотрудников и средние комиссионные среди получающих их сотрудников.
-- Под комиссионными здесь понимается процент комиссионных - commission_pct
SELECT COUNT(employee_id) - (COUNT(employee_id) - COUNT(commission_pct)), SUM(commission_pct)/COUNT(employee_id), AVG(commission_pct)
FROM employees