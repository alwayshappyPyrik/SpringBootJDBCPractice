create table test.customers
(
    id           bigserial primary key,
    firstname    varchar(255) NOT NULL,
    surname      varchar(255) NOT NULL,
    age          smallint     NOT NULL check (age > 0 AND age < 130),
    phone_number varchar(50)
);

create table test.orders
(
    id           bigserial primary key,
    date         date         NOT NULL DEFAULT now(),
    customer_id  bigint references test.customers (id) ON DELETE CASCADE,
    product_name varchar(500) NOT NULL,
    amount       real
);
