select
date_format(trans_date, '%Y-%m') as month,
country,
count(1) as trans_count,
sum(state = 'approved') as approved_count,
sum(amount) as trans_total_amount,
sum(case state when 'approved' then amount else 0 end) as approved_total_amount
from Transactions
group by date_format(trans_date, '%Y-%m'), country