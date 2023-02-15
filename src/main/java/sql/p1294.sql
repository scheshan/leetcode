select A.country_name, case when B.avg <= 15 then 'Cold' when B.avg >= 25 then 'Hot' else 'Warm' end as weather_type
from Countries A
join (
    select country_id, sum(weather_state) / count(1) as avg
    from Weather
    where day >= '2019-11-01' and day < '2019-12-01'
    group by country_id
) B on A.country_id = B.country_id