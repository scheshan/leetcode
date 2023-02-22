select count(1) as accounts_count from Subscriptions A
where (A.start_date between '2021-01-01' and '2021-12-31' or A.end_date between '2021-01-01' and '2021-12-31')
and A.account_id not in (
    select account_id from Streams B
    where stream_date between '2021-01-01' and '2021-12-31'
)