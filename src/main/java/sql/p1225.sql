select T.period_state, min(T.date) as start_date, max(T.date) as end_date
from (
    select
    'succeeded' as period_state,
    success_date as date,
    case when datediff(@pre_date, @pre_date := A.success_date) = -1 then @id else @id := @id + 1 end as id
    from Succeeded A,
    (select @id := 0, @pre_date := null) as temp

    union all

    select
    'failed' as period_state,
    fail_date as date,
    case when datediff(@pre_date, @pre_date := A.fail_date) = -1 then @id else @id := @id + 1 end as id
    from Failed A
) T
where T.date >= '2019-01-01' and T.date <= '2019-12-31'
group by T.id
order by start_date