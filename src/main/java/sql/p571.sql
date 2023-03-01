with recursive T1 as (
    select num, frequency from Numbers
    union all
    select num, frequency - 1 from T1 where frequency > 1
),
T2 as (
    select num, row_number() over(order by num) as r from T1
),
T3 as (
    select * from T2
    where r between (select (round(count(1) / 2)) from T2) and (select (round(count(1) / 2)) + 1 - (count(1) % 2) from T2)
)
select round(sum(num) / count(1),1) as median from T3