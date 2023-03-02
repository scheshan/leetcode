with A as (
    select name, row_number() over(order by name) as r from Student
    where continent = 'America'
),
B as (
    select name, row_number() over(order by name) as r from Student
    where continent = 'Asia'
),
C as (
    select name, row_number() over(order by name) as r from Student
    where continent = 'Europe'
)
select
A.name as `America`,
B.name as `Asia`,
C.name as `Europe`
from A
left join B on A.r = B.r
left join C on A.r = C.r