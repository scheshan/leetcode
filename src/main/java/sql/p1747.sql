select distinct account_id from LogInfo A
where exists
(
    select 1 from LogInfo B
    where A.account_id = B.account_id
    and A.ip_address != B.ip_address
    and ((B.login >= A.login and B.login <= A.logout) || (B.logout >= A.login and B.logout <= A.logout))
)