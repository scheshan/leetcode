with T1 as (
    select employee_id, salary from (
        select employee_id, sum(salary) over(order by salary) as salary
        from Candidates
        where experience = 'Senior'
    ) T
    where salary <= 70000
), T2 as (
    select employee_id, salary from (
        select employee_id, sum(salary) over(order by salary) as salary
        from Candidates
        where experience = 'Junior'
    ) T
    where salary <= 70000 - ifnull((select max(salary) from T1), 0)
)
select employee_id from T1
union all select employee_id from T2