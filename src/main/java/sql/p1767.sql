with recursive T1 as (
    select task_id, subtasks_count as subtask_id from Tasks
    union all
    select task_id, subtask_id - 1 as subtask_id
    from T1
    where subtask_id > 1
)
select T1.task_id, T1.subtask_id from T1
left join Executed B on T1.task_id = B.task_id and T1.subtask_id = B.subtask_id
where B.task_id is null