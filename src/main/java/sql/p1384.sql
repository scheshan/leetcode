with recursive T1 (y) as (
    select min(year(period_start)) from Sales
    union all
    select y + 1 from T1
    where y < (select max(year(period_end)) from Sales)
),
T2 as (
    select
    A.product_id,
    T1.y,
    A.average_daily_sales * (datediff(if(A.period_end < makedate(T1.y+1, 1), date_add(A.period_end, interval 1 day), makedate(T1.y+1, 1)), if(A.period_start > makedate(T1.y, 1), A.period_start, makedate(T1.y, 1)))) as total_amount
    from Sales A
    join T1 on year(A.period_start) <= T1.y and year(A.period_end) >= T1.y
),
T3 as (
    select product_id, y, sum(total_amount) as total_amount
    from T2
    group by product_id, y
)
select
A.product_id,
B.product_name,
convert(A.y, char) as report_year,
A.total_amount
from T3 A
join Product B on A.product_id = B.product_id
order by product_id, report_year