select employee_id, B.team_size as team_size
from Employee A
join
(
     select team_id, count(1) as team_size
     from Employee
     group by team_id
) B on A.team_id = B.team_id