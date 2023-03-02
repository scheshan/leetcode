select distinct A.id, name
from Accounts A
join
(
    select
    id,
    sum(1) over(partition by id order by login_date range between interval 4 day preceding and current row) as s
    from (
        select distinct id, login_date from Logins
    ) T1
) B on A.id = B.id
where B.s = 5
order by id