-- Из таблицы LOCATIONS выведите адрес (STREET_ADDRESS) и позицию второго буквенного символа, входящего в ту же строку (адрес).
-- Указание: Использование REGEXP_INSTR.
SELECT locations.street_address, REGEXP_INSTR(locations.street_address, '[a-z]')
FROM locations