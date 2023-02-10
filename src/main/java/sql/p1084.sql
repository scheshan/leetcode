select A.product_id, A.product_name
from Product A
    join (
    select product_id, min(sale_date) as m1, max(sale_date) as m2
    from Sales
    group by product_id
    having(m1 between '2019-01-01' and '2019-03-31' and m2 between '2019-01-01' and '2019-03-31')
) B
on A.product_id = B.product_id