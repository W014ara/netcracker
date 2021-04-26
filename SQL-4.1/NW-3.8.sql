-- Выведите имена (companyname) и адреса (address) заказчиков (customers), не сделавших ни одного заказа (orders)
SELECT customers.companyname, customers.address FROM customers, orders
WHERE customers.customerid = orders.customerid(+) 
AND orders.customerid IS NULL