select
    /*%expand*/*
from tasks
where day = /*now*/'2020-6-22'
AND user_id = /*userId*/'1'