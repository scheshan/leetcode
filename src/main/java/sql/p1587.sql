select A.name as NAME, B.BALANCE from Users A
join
(
    select account, sum(amount) as balance from Transactions
    group by account
    having balance > 10000
) B on A.account = B.account