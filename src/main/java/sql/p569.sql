with T1 as (
    select id, company, salary, rank() over(partition by company order by salary desc, id desc) as r
    from Employee
),
T2 as (
    select company,
    round(max(r) / 2, 0) as m1,
    round(case when (max(r) % 2 = 0) then (max(r) / 2 + 1) else max(r) / 2 end, 0) as m2
    from T1
    group by company
)
select distinct id, company, salary from (
    select T1.id, T1.company, T1.salary from T1
    join T2 on T1.company = T2.company and T1.r = T2.m1
    union all
    select T1.id, T1.company, T1.salary from T1
    join T2 on T1.company = T2.company and T1.r = T2.m2
) T