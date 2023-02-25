with tmp as (
    select employee_id from Employees
    where manager_id = 1
    and employee_id != 1
),
tmp2 as (
    select employee_id from Employees
    where manager_id in (select * from tmp)
)
select employee_id from tmp
union all
select employee_id from tmp2
union all
select employee_id from Employees where manager_id in (select * from tmp2)