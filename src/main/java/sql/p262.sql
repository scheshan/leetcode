with T1 as (
    select A.status, A.request_at from Trips A
    join Users B on A.client_id = B.users_id
    join Users C on A.driver_id = C.users_id
    where A.request_at between '2013-10-01' and '2013-10-03'
    and B.banned = 'No' and C.banned = 'No'
)
select request_at as Day,
round(sum(status= 'cancelled_by_driver' or status = 'cancelled_by_client') / count(1), 2) as `Cancellation Rate`
from T1
group by request_at