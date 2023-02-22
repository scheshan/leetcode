select user_id, m as biggest_window from
(
    select user_id, visit_date, max(datediff(ifnull(next_visit, '2021-1-1'),visit_date)) as m from
    (
        select
        user_id,
        visit_date,
        (select min(visit_date) from UserVisits B where B.user_id = A.user_id and B.visit_date > A.visit_date) as next_visit
        from UserVisits A
    ) T
    group by user_id
) T1
order by user_id