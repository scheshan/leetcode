select A.customer_id, A.customer_name from Customers A
join (
    select customer_id,
           sum(case product_name when 'A' then 1 else 0 end) as A,
           sum(case product_name when 'B' then 1 else 0 end) as B,
           sum(case product_name when 'C' then 1 else 0 end) as C
    from Orders
    group by customer_id
    having A>0 and B>0 and C=0
) B on A.customer_id = B.customer_id