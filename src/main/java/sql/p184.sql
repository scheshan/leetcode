select A.name as Department, B.name as Employee, B.salary as Salary
from Department A
join Employee B on A.id = B.departmentId
join (
    select departmentId, max(salary) as salary
    from Employee
    group by departmentId
) C on A.id = C.departmentId and B.salary = C.salary