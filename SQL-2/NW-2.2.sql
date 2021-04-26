-- Выведите сегодняшнюю дату в следующих четырех столбцах (все столбцы - строкового типа):
-- Год (4 цифры)
-- Полное название месяца заглавными буквами
-- День месяца (число)
-- День недели словом заглавными буквами
-- Пример вывода:
-- 2011	OCTOBER	04	TUESDAY
SELECT
TO_CHAR(SYSTIMESTAMP, 'YYYY') AS O, 
TO_CHAR(SYSTIMESTAMP,'MONTH') AS T, 
TO_CHAR(SYSTIMESTAMP, 'dd') AS H,
TO_CHAR(SYSTIMESTAMP,'DAY') AS F
FROM dual