select
    /*%expand*/*
from tasks
where user_id = /*userId*/1
/*%if taskName != null*/
	AND task_name
	Like /* @infix(taskName) */'todoName'
/*%end*/
/*%if day != null*/
	AND
	/*day*/'2020-7-2' = day
/*%end*/
/*%if type != null*/
	AND 
	/*type*/2 = prioritize
/*%end*/
ORDER BY day, prioritize


