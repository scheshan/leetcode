select A.customer_id,A.product_id, B.product_name from
(
    select customer_id, product_id, c, rank() over(partition by customer_id order by c desc) as r
    from (
        select
        customer_id, product_id, count(1) as c
        from Orders
        group by customer_id, product_id
    ) T1
) A
join Products B on A.product_id = B.product_id
where A.r = 1
order by customer_id