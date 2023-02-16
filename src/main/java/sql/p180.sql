select distinct(A.Num) as ConsecutiveNums
from Logs A,Logs B, Logs C
where A.id = B.id - 1 and A.id = C.id - 2 and A.num = B.num and A.num = C.num