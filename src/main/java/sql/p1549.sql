select B.product_name, A.product_id, A.order_id, A.order_date from Orders A
join Products B on A.product_id = B.product_id
join (
    select product_id, max(order_date) as m from Orders
    group by product_id
) C on A.product_id = C.product_id and A.order_date = C.m
order by product_name, product_id, order_id