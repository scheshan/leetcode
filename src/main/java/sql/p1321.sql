with tmp as
(
    select visited_on, sum(amount) over(order by visited_on) as s
    from Customer
)
select distinct
A.visited_on,
A.s - ifnull(B.s,0) as amount,
round((A.s - ifnull(B.s,0) ) / 7, 2) as average_amount
from tmp A
left join tmp B on A.visited_on = date_add(B.visited_on, interval 7 day)
limit 6, 1000000