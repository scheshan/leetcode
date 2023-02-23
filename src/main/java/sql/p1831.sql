select transaction_id from
(
    select transaction_id, rank() over(partition by date_format(day, '%y-%m-%d') order by amount desc) as r
    from Transactions
) T
where r = 1
order by transaction_id