select project_id, employee_id from
(
    select A.project_id, B.employee_id, B.experience_years, rank() over(partition by project_id order by experience_years desc) as r
    from Project A
    join Employee B on A.employee_id = B.employee_id
) T where r = 1