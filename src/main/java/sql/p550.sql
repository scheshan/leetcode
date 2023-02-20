with T1 as (
    select player_id, min(event_date) as event_date
    from Activity
    group by player_id
),
T2 as (
    select A.player_id from Activity A
    join T1 B on A.player_id = B.player_id and A.event_date = date_add(B.event_date, interval 1 day)
)
select round(
    (select count(1) from T2)
    /
    (select count(1) from T1)
, 2) as fraction