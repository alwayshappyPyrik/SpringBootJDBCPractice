insert
into test.customers (id, firstname, surname, age, phone_number)
values (1, 'yaroslav', 'pyrikov', 31, ''),
       (2, 'vasiliy', 'ogurсhov', 31, ''),
       (3, 'vania', 'poddupniy', 1, ''),
       (4, 'alexey', 'kazakov', 40, '');

insert
into test.orders (id, customer_id, product_name, amount)
values (1, 1, 'Майка', 300),
       (2, 2, 'Свитер', 1500),
       (3, 3, 'Куртка', 10000),
       (4, 4, 'Кроссовки', 5000);