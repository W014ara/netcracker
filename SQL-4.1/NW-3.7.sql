-- Выведите идентификатор (supplierid) всех поставщиков (suppliers), поставляющих продукцию (products) только одной категории (categories),
-- а также имя этой категории (categoryname)
SELECT DISTINCT g.supplierid, r.categoryname FROM products g, categories r
WHERE g.supplierid = ANY (SELECT supplierid FROM (
SELECT DISTINCT a.supplierid, COUNT(c.categoryname)
FROM suppliers a, products b, categories c
WHERE a.supplierid = b.supplierid
AND b.categoryid = c.categoryid
HAVING COUNT(UNIQUE(c.categoryname)) = 1
GROUP BY a.supplierid
))
AND g.categoryid = r.categoryid