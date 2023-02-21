select min(log_id) as start_id, max(log_id) as end_id
from (
    select log_id, log_id - row_number() over() as diff from Logs
) T
group by diff