select product_name
from test.orders
         INNER JOIN test.customers cus ON orders.customer_id = cus.id
where firstname = lower(:firstname);

