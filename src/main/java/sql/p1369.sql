with T1 as (
    select username, activity, startDate, endDate, rank() over(partition by username order by startDate desc) as r
    from UserActivity
),
T2 as (
    select distinct username from UserActivity
)
select
A.username,
ifnull(C.activity, B.activity) as activity,
ifnull(C.startDate, B.startDate) as startDate,
ifnull(C.endDate, B.endDate) as endDate
from T2 A
join T1 B on A.username = B.username and B.r = 1
left join T1 C on A.username = C.username and C.r = 2