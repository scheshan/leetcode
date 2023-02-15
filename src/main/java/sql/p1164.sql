with A as (
    select distinct product_id
    from Products
),
B as (
    select product_id, max(change_date) as change_date
    from Products
    where change_date <= '2019-08-16'
    group by product_id
)
select A.product_id, ifnull(C.new_price, 10) as price
from A
left join B on A.product_id = B.product_id
left join Products C on A.product_id = C.product_id and B.change_date = C.change_date