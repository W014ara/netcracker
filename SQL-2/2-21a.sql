-- Для всех сотрудников выведите дату приема на работу (hire_date), имя сотрудника, его фамилию и текущий стаж,
-- т.е. число полных лет и полных месяцев, которые он отработал с даты приема.
-- Число лет и месяцев следует выводить даже в том случае, если это число 0. Пример вывода стажа:
-- 12 Years, 1 Months
-- Указание: Использовать MONTHS_BETWEEN и числовые функции.
-- Примечание: следует обратить внимание на сотрудника, которому отдел кадров ошибочно указал дату приема в будущем.
-- В этом случае число месяцев (и лет) будет отрицательным. Например:
-- 0 Years, -6 Months
SELECT hire_date,
       first_name,
       last_name,
       FLOOR(FLOOR(MONTHS_BETWEEN(SYSTIMESTAMP, hire_date)) / 12) || ' Years, ' ||
       (FLOOR(MONTHS_BETWEEN(SYSTIMESTAMP, hire_date)) - FLOOR(FLOOR(MONTHS_BETWEEN(SYSTIMESTAMP, hire_date)) / 12) * 12) || 
       ' Months' AS "EXPERIENCE"
FROM employees;