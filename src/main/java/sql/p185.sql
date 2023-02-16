select A.name as Department, B.name as Employee, B.salary as Salary
from Department A
join (
    select
    departmentId,
    name,
    salary,
    dense_rank() over(partition by departmentId order by salary desc) as r
    from Employee
) B on A.id = B.departmentId
where B.r <= 3