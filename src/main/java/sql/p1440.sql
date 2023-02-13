select left_operand, operator,right_operand, case value when 1 then 'true' else 'false' end as value
from
(
    select
    A.left_operand, A.operator, A.right_operand,
    case A.operator when '>' then (B.value > C.value) when '<' then (B.value < C.value) else (B.value = C.value) end as value
    from Expressions A
    join Variables B on A.left_operand = B.name
    join Variables C on A.right_operand = C.name
) T