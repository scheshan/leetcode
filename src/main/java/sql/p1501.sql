with T1 as (
    select C.name, A.duration
    from Calls A
    join Person B on A.caller_id = B.id
    join Country C on left(B.phone_number, 3) = C.country_code
    union all
    select C.name, A.duration
    from Calls A
    join Person B on A.callee_id = B.id
    join Country C on left(B.phone_number, 3) = C.country_code
)
select
name as country
from T1
group by name
having sum(duration) / count(1) > (select sum(duration) / count(1) from Calls)