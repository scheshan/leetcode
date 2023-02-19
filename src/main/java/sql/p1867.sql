with tmp as
(
    select
    order_id,
    max(quantity) as m,
    sum(quantity) / count(1) as avg
    from OrdersDetails
    group by order_id
)
select order_id from tmp
where m > (select max(avg) from tmp)