select A.*, B.name from
(
    select reports_to as employee_id, count(1) as reports_count, sum(age) / count(1) as average_age from Employees
    group by reports_to
) A
join Employees B on A.employee_id = B.employee_id
order by employee_id