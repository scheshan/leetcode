select A.name as customer_name, A.customer_id, B.order_id, B.order_date
from Customers A
join (
    select
    customer_id,
    order_id,
    order_date,
    row_number() over(partition by customer_id order by order_date desc) as rid
    from Orders
) B on A.customer_id = B.customer_id
where B.rid <= 3
order by customer_name, customer_id, order_date desc