select A.player_id, B.player_name, count(1) as grand_slams_count  from
(
    select Wimbledon as player_id  from Championships
    union all select Fr_open as player_id  from Championships
    union all select US_open as player_id  from Championships
    union all select Au_open as player_id  from Championships
) A
join Players B on A.player_id = B.player_id
group by player_id