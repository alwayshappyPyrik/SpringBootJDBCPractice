select product_name
from test.orders
         INNER JOIN test.customers cus ON orders.id = cus.customer_id
where firstname = lower(:firstname);

