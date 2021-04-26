-- Из таблицы LOCATIONS выведите первым столбцом уникальный идентификатор местоположения (LOCATION_ID),
-- вторым столбцом street — адрес, образованный усечением слева цифр и пробелов у колонки STREET_ADDRESS.
-- Указание: Использование LTRIM.
SELECT locations.location_id, LTRIM(locations.street_address, ' 0123456789') as street FROM LOCATIONS