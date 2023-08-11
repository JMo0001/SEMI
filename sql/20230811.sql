desc tbl_vote;

desc tbl_member;

select mno, mname, mcity, count(mno) cnt
    from tbl_member m
    join tbl_vote v using(mno)
    group by mno, mname, mcity
    order by mcity, cnt desc
;
select mcity, count(mno) as "all" 
    from tbl_member 
    join tbl_vote using(mno) 
    group by mcity
    ;

create or replace view v_all(mcity, al)
    as select mcity, count(mno) as "al" 
        from tbl_member 
        join tbl_vote using(mno) 
        group by mcity
;
create or replace view v_result (mno, mname, mcity, cnt)
as
select mno, mname, mcity, count(mno) cnt
    from tbl_member m
    join tbl_vote v using(mno)
    group by mno, mname, mcity
    order by mcity, cnt desc
;

select mno, mname, mcity, cnt, round(cnt/al*100,1) "득표율"
    from v_result r
    join v_all a using(mcity)
;

select mno, mname, mcity, cnt, round(ratio_to_report(cnt) over(PARTITION by mcity)*100,1)||'%' per
from
(
select mno, mname, mcity, count(mno) cnt
    from tbl_member
    join tbl_vote using(mno)
    group by mno, mname, mcity
    order by mcity, cnt desc
    )
;