select A.name as Employee
from Employee A
join Employee B on A.managerId = B.id
where A.salary > B.salary