select A.name from Candidate A
join (
    select candidateId, rank() over(order by c desc) as r from
    (
        select candidateId, count(1) as c
        from Vote
        group by candidateId
    ) T1
) B on A.id = B.candidateId
where B.r = 1