select player_id, device_id from (
    select
    player_id,
    device_id,
    rank() over(partition by player_id order by event_date) as r
    from Activity
) T
where r = 1