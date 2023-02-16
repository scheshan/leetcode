select A.seat_id from Cinema A
left join Cinema B on A.seat_id = B.seat_id - 1 and B.free = 1
left join Cinema C on A.seat_id = C.seat_id + 1 and C.free = 1
where A.free = 1 and (B.seat_id is not null or C.seat_id is not null)