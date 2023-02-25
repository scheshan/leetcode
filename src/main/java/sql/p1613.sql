with recursive T1 (id) as (
    select 1
    union all
    select id+1 from T1
    where id < (select max(customer_id) from Customers)
)
select id as ids from T1
where id not in (
    select customer_id from Customers
)